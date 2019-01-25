package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserDto;

public interface UserService {
	UserDto getUserById(Integer userId);
	public UserDto saveUser(UserDto userDto) throws Exception;
}
