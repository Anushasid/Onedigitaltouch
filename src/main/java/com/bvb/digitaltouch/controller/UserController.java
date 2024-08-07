package com.bvb.digitaltouch.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.ResponceEntity.BvbMcaResponse;
import com.bvb.digitaltouch.dto.UserDto;
import com.bvb.digitaltouch.modules.User;
import com.bvb.digitaltouch.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

  
    @GetMapping("/all")
	public BvbMcaResponse getAllUser() {
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	String statusMessage = "";
    	try {
    		logger.info("All users are trying print");
    		List<UserDto> users = userService.getAllUser();
    		status = HttpStatus.OK;
    		return new BvbMcaResponse(users,status);
    	}catch(BvbMcaException e) {
    		statusMessage = "Error while reading all the users;"+e.getMessage();
    	}catch(Exception e) {
    		e.printStackTrace();
			logger.error("Error while reading user");
    		
    	}
    	return new BvbMcaResponse(statusMessage, status);
    }

	@PostMapping
	public BvbMcaResponse registrationNewUser(@RequestBody User user) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
	String statusMessage = "";
		try {
			logger.info("Trying to add user");
			userService.addNewUser(user);
			status = HttpStatus.OK;
			statusMessage="User created successfully";
		}catch(BvbMcaException e) {
			statusMessage = "Error while creating user;"+e.getLocalizedMessage();
			 logger.error("Error while adding new user");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("An Unexpected ereor while creating user");
			
		}
		return new BvbMcaResponse(statusMessage, status);
		
		
	}
	

	
	@DeleteMapping("/{userId}")
	public BvbMcaResponse deleteUser(@PathVariable("userId")Integer userId) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage = "";
		try {
			logger.info("Trying to delete the user");
			userService.deleteUser(userId);
			status = HttpStatus.OK;
			statusMessage="User deleted successfully";
			}catch(BvbMcaException e){
				statusMessage="Error while deleting user "+e.getMessage();
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Error while deleting user");
			
		}
		return new BvbMcaResponse(statusMessage, status);
	}
	
	@PutMapping("/{userId}")
	public BvbMcaResponse updateUser(
			@PathVariable("userId")Integer userId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage = "";
		try {
			logger.info("Trying to update the user data");
		userService.updateUser(userId, name, email);
		status = HttpStatus.OK;	
		statusMessage = "updated successfully";
		}catch(BvbMcaException e) {
			e.printStackTrace();
			logger.error("Error while updating user");
			statusMessage="Error while updating user  "+e.getMessage();
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Error while updating user");
		}
		return new BvbMcaResponse(statusMessage,status);
		
		
	}
}
