package com.akash.owlAi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akash.owlAi.dto.UserDTO;
import com.akash.owlAi.dto.UserResponseDTO;
import com.akash.owlAi.entity.user;
import com.akash.owlAi.exception.DuplicateResourceException;
import com.akash.owlAi.exception.ResourceNotFoundException;
import com.akash.owlAi.repository.UserRepository;

import ch.qos.logback.classic.Logger;

@Service
public class UserServiceImpl implements UserService{
	
    //private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserResponseDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream().map(this::convertToResponseDTO).collect(Collectors.toList());
		 
	}

	@Override
	public UserResponseDTO getUserById(Long id) {
		// TODO Auto-generated method stub
		user user1 = userRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id: "+id));
		return convertToResponseDTO(user1);
	}

	@Transactional
	@Override
	public UserResponseDTO createUser(UserDTO userDto) {
        // Check if email already exists
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new DuplicateResourceException("Email already exists: " + userDto.getEmail());
        }
        
        user user = convertToEntity(userDto);
        user savedUser = userRepository.save(user);
        return convertToResponseDTO(savedUser);
	}

	@Transactional
	@Override
	public UserResponseDTO updateUser(Long id, UserDTO userDTO) {
        user existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        
        // Check if email is being changed and if it already exists for another user
        if (!existingUser.getEmail().equals(userDTO.getEmail()) && 
            userRepository.existsByEmailAndIdNot(userDTO.getEmail(), id)) {
            throw new DuplicateResourceException("Email already exists: " + userDTO.getEmail());
        }
        
        existingUser.setFirstName(userDTO.getFirstName());
        existingUser.setLastName(userDTO.getLastName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPhoneNumber(userDTO.getPhoneNumber());
        
        user updatedUser = userRepository.save(existingUser);
        return convertToResponseDTO(updatedUser);
	}

	@Transactional
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
        user user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
		
	}


	@Override
	public UserResponseDTO getUserByEmail(String email) {
		// TODO Auto-generated method stub
        user user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));
        return convertToResponseDTO(user);
	}
	
    // Helper methods for conversion
    private user convertToEntity(UserDTO userDTO) {
        user user = new user();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
	
    private UserResponseDTO convertToResponseDTO(user user) {
        return new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

}
