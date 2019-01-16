package com.ecommerce.user.dao;

import com.ecommerce.user.dto.UserDto;

public interface UserDao {
	UserDto getUserById(String userId);
}
