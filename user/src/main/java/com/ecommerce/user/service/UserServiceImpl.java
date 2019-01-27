package com.ecommerce.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.dao.UserDao;
import com.ecommerce.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public UserDto saveUser(UserDto userDto) throws Exception {
		return userDao.saveUser(userDto);
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		return userDao.updateUser(userDto);
		
	}

	@Override
	public boolean loginUser(UserDto userDto) throws Exception {
		return userDao.loginUser(userDto);
		
	}
	
	

}
