package com.bvb.digitaltouch.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dao.FeedbackRepository;
import com.bvb.digitaltouch.dao.UserRepository;
import com.bvb.digitaltouch.dto.FeedbackDto;
import com.bvb.digitaltouch.modules.Feedback;
import com.bvb.digitaltouch.modules.User;
import com.bvb.digitaltouch.service.FeedbackService;
import com.bvb.digitaltouch.util.FeedbackUtil;
@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	 Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private FeedbackRepository feedbackRepository;
	 
	 public List<FeedbackDto> getAllFeedback(){
		 List<FeedbackDto> listOfDtos = feedbackRepository.findAll().stream().map(FeedbackUtil::convertFeedbackEntityToDto)
				 .collect(Collectors.toList());
		 return listOfDtos;
	 }
	 public void createFeedback(FeedbackDto feedbackDto,Integer userId)throws BvbMcaException{
		 Optional<User> user = userRepository.findById(userId);
		 if(user.isPresent()) {
			 logger.info("User is present");
			 User users = user.get();
			 Feedback feedback = FeedbackUtil.convertFeedbackDtoToEntity(feedbackDto);
			 feedback.setUser(users); 
			 feedbackRepository.save(feedback);
			 logger.info("Feedback created successfully");
			 }
		 else {
				logger.info("User with user Id {} is not present",userId);
				throw new BvbMcaException("User not found");
				
			}

	 }
	 


}



