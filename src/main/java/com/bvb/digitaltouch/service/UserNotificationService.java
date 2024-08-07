package com.bvb.digitaltouch.service;

import java.util.List;
import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dto.UserNotificationDto;

public interface UserNotificationService {
	
	public abstract List<UserNotificationDto> getAllUserNotification()throws BvbMcaException;
	
	public abstract void createUserNotification(UserNotificationDto usernotification,Integer userId) throws BvbMcaException; 

}
