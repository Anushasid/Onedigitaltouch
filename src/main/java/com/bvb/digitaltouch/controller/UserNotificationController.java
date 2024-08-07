package com.bvb.digitaltouch.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.ResponceEntity.BvbMcaResponse;
import com.bvb.digitaltouch.dto.UserNotificationDto;
import com.bvb.digitaltouch.service.UserNotificationService;

@RestController
@RequestMapping("/usernotification")
public class UserNotificationController {
	@Autowired
	private UserNotificationService usernotificationService;
	
	Logger logger = LoggerFactory.getLogger(UserNotificationController.class);
	
	
	@GetMapping("/all")
	public BvbMcaResponse getAllUserNotification() {
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	String statusMessage = "";
    	try {
    		logger.info("Trying to read all usernotification");
    		List<UserNotificationDto> usernotifications = usernotificationService.getAllUserNotification();
    		status = HttpStatus.OK;
    		return new BvbMcaResponse(usernotifications,status);
    	}catch(BvbMcaException e) {
    		statusMessage = "Error while reading all the usernotification;"+e.getMessage();
    	}catch(Exception e) {
    		e.printStackTrace();
			logger.error("Error while reading usernotification");
    		
    	}
    	return new BvbMcaResponse(statusMessage, status);
    }
	
	@PostMapping("/user-id/{userId}")
	public BvbMcaResponse createUserNotification(@RequestBody UserNotificationDto usernotification,@PathVariable("userId") Integer userId ) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage = "";
		try {
	
			usernotificationService.createUserNotification(usernotification,userId);
			status = HttpStatus.OK;
			statusMessage ="User notification created successfully check in logger";
			
		}catch(BvbMcaException e){
			statusMessage = "Error while creating or sending the feedback;" + e.getMessage();

			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
	}
		return new BvbMcaResponse(statusMessage, status);
	}
}

	
	
	
	
	


