package com.akash.owlAi.service;

import java.util.List;

import com.akash.owlAi.dto.UserDTO;
import com.akash.owlAi.dto.UserResponseDTO;

public interface UserService {
	
	List<UserResponseDTO> getAllUsers();
	
	UserResponseDTO getUserById(Long id);
	
	UserResponseDTO createUser(UserDTO userDto);
	
	UserResponseDTO updateUser(Long id, UserDTO userDTO);
	
	void deleteUser(Long id);
	
	UserResponseDTO getUserByEmail(String email);

}
