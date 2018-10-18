package com.javen.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.dao.UserMapper;
import com.javen.model.User;
import com.javen.service.IUserService;


@Service("userService")
public class UserSerivceImpl implements IUserService {

	
	@Resource
	private UserMapper userMapper;
	
	
	public User getUserById(int userId)
	{
		return this.userMapper.selectByPrimaryKey(userId);
	}
	
}
