package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;


import com.bvb.digitaltouch.dto.FeedbackDto;

import com.bvb.digitaltouch.modules.Feedback;

public class FeedbackUtil {
	
		public static FeedbackDto convertFeedbackEntityToDto(Feedback feedback) {
			FeedbackDto dto= new FeedbackDto();
			BeanUtils.copyProperties(feedback, dto);
			return dto;
		}
		
		
		public static Feedback convertFeedbackDtoToEntity(FeedbackDto dto) {
			Feedback feedback = new Feedback();
			BeanUtils.copyProperties(dto, feedback);
			return feedback;
		}


}
