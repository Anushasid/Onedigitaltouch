package com.bvb.digitaltouch.service;

import java.util.List;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dto.FeedbackDto;

public interface FeedbackService {
	public abstract List<FeedbackDto> getAllFeedback() throws BvbMcaException;
	
    public abstract void createFeedback(FeedbackDto feedback,Integer userId) throws BvbMcaException;

}
