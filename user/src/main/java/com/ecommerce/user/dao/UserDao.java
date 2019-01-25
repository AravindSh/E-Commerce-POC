package com.ecommerce.user.dao;

import com.ecommerce.user.dto.UserDto;

public interface UserDao {
	UserDto getUserById(Integer userId);
	public UserDto saveUser(UserDto userDto) throws Exception;
}
