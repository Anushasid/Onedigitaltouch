package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;
import com.bvb.digitaltouch.dto.UserNotificationDto;
import com.bvb.digitaltouch.modules.UserNotification;

public class UserNotificationUtil {
	public static UserNotificationDto convertUserNotificationEntityToDto(UserNotification usernotification ) {
		UserNotificationDto dto=new UserNotificationDto();
		BeanUtils.copyProperties(usernotification, dto);
		return dto;
    }

	
	
	public static UserNotification convertUserNotificationDtoToEntity(UserNotificationDto dto)
	{
		UserNotification usernotification=new UserNotification();
		BeanUtils.copyProperties(dto,usernotification);
		
		return usernotification;
	}

}
