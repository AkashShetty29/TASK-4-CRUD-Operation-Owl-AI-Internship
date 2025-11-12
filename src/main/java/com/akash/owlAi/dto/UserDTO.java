package com.akash.owlAi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
	 
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
	private String firstName;
	
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
	private String lastName;
	
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
	private String email;
	
    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
	private String phoneNumber;
    
    
    
    public UserDTO() {
    	
    }

	public UserDTO(String firstName, String lastName, String email, String phoneNumber) {		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
    
    

}
