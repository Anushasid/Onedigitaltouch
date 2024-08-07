package com.bvb.digitaltouch.util;

import org.springframework.beans.BeanUtils;



import com.bvb.digitaltouch.dto.UserDto;

import com.bvb.digitaltouch.modules.User;


public class UserUtil {


    public static UserDto convertUserEntityToDto(User user) {
    	UserDto dto=new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
    }

	
	
	public static User convertUserDtoToEntity(UserDto dto)
	{
		User user=new User();
		BeanUtils.copyProperties(dto,user);
		
		return user;
	}

}
