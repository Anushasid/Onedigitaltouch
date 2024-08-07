package com.bvb.digitaltouch.service;

import java.util.List;

import com.bvb.Exception.BvbMcaException;
import com.bvb.digitaltouch.dto.UserDto;
import com.bvb.digitaltouch.modules.User;


public interface UserService {

	public abstract List<UserDto> getAllUser()throws BvbMcaException;
	
	public abstract String addNewUser(User user)throws BvbMcaException;

	public abstract String deleteUser(Integer userId)throws BvbMcaException;

	public abstract String updateUser(Integer userId, String name, String email)throws BvbMcaException;
	
}
