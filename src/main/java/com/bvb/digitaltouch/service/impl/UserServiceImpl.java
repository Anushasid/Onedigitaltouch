package com.bvb.digitaltouch.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dao.UserRepository;
import com.bvb.digitaltouch.dto.UserDto;
import com.bvb.digitaltouch.modules.User;
import com.bvb.digitaltouch.service.UserService;
import com.bvb.digitaltouch.util.UserUtil;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	// Get method
	public List<UserDto> getAllUser()throws BvbMcaException  {
		try {
			List<UserDto> listOfDtos = userRepository.findAll().stream().map(UserUtil::convertUserEntityToDto)
					.collect(Collectors.toList());
			if(listOfDtos == null) {
				logger.info("There are no users in system");
				throw new BvbMcaException("Empty List of Users");
			}
			return listOfDtos;
			
		}catch(BvbMcaException e) {
			throw new BvbMcaException("Error while getting users");
		}
		
	}
	
	

	// Post method
	@Override
	public String addNewUser(User user)throws BvbMcaException {
		
		try {
			Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
			if (userOptional.isPresent()) {
				throw new BvbMcaException("User exists already");
			}
			userRepository.save(user);
			logger.info("User Added successfully");
			return "Successfully Added";
			
		}catch(Exception e) {
			logger.error("Error while adding new user"+e.getMessage());
			return "Error while adding Added";
			
			}
	}

	// Delete method
	@Override
	public String deleteUser(Integer userId)throws BvbMcaException  {
		try {
			boolean exists = userRepository.existsById(userId);

			if (!exists) {
				throw new BvbMcaException("User with id " + userId + " does not exists");
			}
			logger.info("User is deleted successfully");
			userRepository.deleteById(userId);
			return ("Successfully deleted");
		}catch(Exception e) {
			logger.error("Error while deleting the user");
			return ("Error while deleting the user");
		}
	}

	// Put method
	@Transactional
	@Override
	public String updateUser(Integer userId, String name, String email)throws BvbMcaException  {

		try {
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new  BvbMcaException("User with id " + userId + " does not exist"));

			if (name != null && !name.isEmpty() && !Objects.equals(user.getName(), name)) {
				user.setName(name);
			}

			if (email != null && !email.isEmpty() && !Objects.equals(user.getEmail(), email)) {
				Optional<User> userOptional = userRepository.findByEmail(email);
				if (userOptional.isPresent()) {
					throw new BvbMcaException("User and email Already exist");
				}
				
				user.setEmail(email);
				
			}
			logger.info("User is updated successfully");
			return("User data updated successfully");
		}catch(Exception e) {
			logger.error("Error while updating");
			return ("Error while updating user");
			
		}
	}

}
