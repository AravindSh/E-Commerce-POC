package com.ecommerce.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${spring.profiles}")
	private String springProfile;

	@GetMapping("/ping")
	public String ping() {
		return appName+"|"+springProfile;
	}
}
