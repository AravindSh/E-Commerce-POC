package com.ecommerce.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user.dto.UserDto;
import com.ecommerce.user.service.UserService;

@RestController
public class UserController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	private UserService userService; 
	
	//Constants
	private final String TECHNICAL_ERROR = "Technical Error";
	
	@GetMapping("/ping")
	public ResponseEntity<?> ping() {
		String ping = appName;
		try {
			return new ResponseEntity<>(ping, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{userId}")
	ResponseEntity<?> getUserById(@PathVariable Integer userId){
		try {
			UserDto user = userService.getUserById(userId);
			if(null != user) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/users")
	ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
		try {
			UserDto user = userService.saveUser(userDto);
			if(null != user) {
				return new ResponseEntity<>(user,  HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("Failed to Save", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
