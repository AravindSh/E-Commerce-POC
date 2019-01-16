package com.ecommerce.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.user.dao.UserDao;
import com.ecommerce.user.dto.UserDto;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto getUserById(String userId) {
		return userDao.getUserById(userId);
	}
	
	

}
