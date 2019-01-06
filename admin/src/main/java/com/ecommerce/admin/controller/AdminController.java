package com.ecommerce.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.admin.entity.ProductCatalog;
import com.ecommerce.admin.service.AdminService;

@RestController
public class AdminController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${spring.profiles}")
	private String springProfile;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/ping")
	public String ping() {
		return appName+"|"+springProfile;
	}
	
	@GetMapping("/products")
	List<ProductCatalog> getProductsByType(@RequestParam String type) {
		return adminService.getAllProductsByType(type);
	}
	
	 
}
