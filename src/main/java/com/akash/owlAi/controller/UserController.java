package com.akash.owlAi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.owlAi.dto.UserDTO;
import com.akash.owlAi.dto.UserResponseDTO;
import com.akash.owlAi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
		List<UserResponseDTO> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
		UserResponseDTO user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable String email){
		UserResponseDTO userByEmail = userService.getUserByEmail(email);
		
		return new ResponseEntity<>(userByEmail, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> createNewUser(@Valid @RequestBody UserDTO userDTO){
		UserResponseDTO createdUser = userService.createUser(userDTO);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO){
		UserResponseDTO updatedUser = userService.updateUser(id, userDTO);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
