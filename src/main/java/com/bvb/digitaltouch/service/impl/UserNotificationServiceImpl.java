package com.bvb.digitaltouch.service.impl;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dao.UserNotificationRepository;
import com.bvb.digitaltouch.dao.UserRepository;
import com.bvb.digitaltouch.dto.UserNotificationDto;
import com.bvb.digitaltouch.modules.User;
import com.bvb.digitaltouch.modules.UserNotification;
import com.bvb.digitaltouch.service.UserNotificationService;
import com.bvb.digitaltouch.util.UserNotificationUtil;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {
	Logger logger = LoggerFactory.getLogger(UserNotificationServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserNotificationRepository usernotificationRepository;
	
	public List<UserNotificationDto> getAllUserNotification(){
		List<UserNotificationDto> listOfDto = usernotificationRepository.findAll().stream().map(UserNotificationUtil::convertUserNotificationEntityToDto)
				.collect(Collectors.toList());
		return listOfDto;
		
	}
	public void createUserNotification(UserNotificationDto usernotificationDto,Integer userId)throws BvbMcaException{
			 Optional<User> user = userRepository.findById(userId);
			 if(user.isPresent()) {
				 logger.info("User is present");
				 User users = user.get();
				 UserNotification usernotification = UserNotificationUtil.convertUserNotificationDtoToEntity(usernotificationDto);
				 usernotification.setUser(users); 
				 usernotificationRepository.save(usernotification);
				 logger.info("User notification created successfully");
				 }
			 else {
					logger.info("User with user Id {} is not present",userId);
					throw new BvbMcaException("User not found");
					
				}

		 }
		 


	}



