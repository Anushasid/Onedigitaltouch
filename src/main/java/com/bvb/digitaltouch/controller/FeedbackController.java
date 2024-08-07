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
import com.bvb.digitaltouch.dto.FeedbackDto;
import com.bvb.digitaltouch.service.FeedbackService;


@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	
	@Autowired
	private FeedbackService feedbackService;
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);
	
	@GetMapping("/all")
	public BvbMcaResponse getAllFeedback() {
    	HttpStatus status = HttpStatus.BAD_REQUEST;
    	String statusMessage = "";
    	try {
    		logger.info("Trying to read all feedback");
    		List<FeedbackDto> feedbacks = feedbackService.getAllFeedback();
    		status = HttpStatus.OK;
    		return new BvbMcaResponse(feedbacks,status);
    	}catch(BvbMcaException e) {
    		statusMessage = "Error while reading all the feedbcak;"+e.getMessage();
    	}catch(Exception e) {
    		e.printStackTrace();
			logger.error("Error while reading feedback");
    		
    	}
    	return new BvbMcaResponse(statusMessage, status);
    }
	
	@PostMapping("/user-id/{userId}")
	public BvbMcaResponse createFeedback(@RequestBody FeedbackDto feedback,@PathVariable("userId") Integer userId) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String statusMessage ="";
		try {
			feedbackService.createFeedback(feedback,userId);
			status = HttpStatus.OK;
			statusMessage = "Feedback is created or sent successfully check in logger";
		}catch(BvbMcaException e) {
			statusMessage = "Error while creating or sending the feedback;"+e.getMessage();
			
		}catch(Exception e) {
			e.printStackTrace();
		logger.error(e.getMessage());	
		
		}
		return new BvbMcaResponse(statusMessage, status);
	}
	


}
