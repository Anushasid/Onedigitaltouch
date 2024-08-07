package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;

import com.bvb.digitaltouch.dto.GlobalNotificationDto;

import com.bvb.digitaltouch.modules.GlobalNotification;




public class GlobalNotificationUtil {
	public static GlobalNotificationDto convertGlobalNotificationEntityToDto(GlobalNotification globalnotification) {
		GlobalNotificationDto dto=new GlobalNotificationDto();
		BeanUtils.copyProperties(globalnotification, dto);
		return dto;
    }

	
	
	public static GlobalNotification convertGlobal_NotificationDtoToEntity(GlobalNotificationDto dto)
	{
		GlobalNotification globalnotification=new GlobalNotification();
		BeanUtils.copyProperties(dto,globalnotification);
		
		return globalnotification;
	}

}
