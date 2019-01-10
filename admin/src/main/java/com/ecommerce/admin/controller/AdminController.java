package com.ecommerce.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.admin.entity.ObjectId;
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
	
	@GetMapping("/products/{productId}")
	ProductCatalog getByProductId(@PathVariable String productId) {
		return adminService.getByProductId(productId);
	}
	
	@DeleteMapping("/products/{productId}")
	void deleteProuctById(@PathVariable String productId) {
		adminService.deleteProuctById(productId);
	}
	
	@PostMapping("/products")	
	void saveProduct(@RequestBody ProductCatalog productCatalog) {
		adminService.saveProduct(productCatalog);
	}
	
	@PutMapping("/products/{productId}")
	void updateProduct(@RequestBody ProductCatalog productCatalog, @PathVariable String productId) {
		ObjectId id = new ObjectId();
		id.setOid(productId);
		productCatalog.setId(id);
		adminService.updateProduct(productCatalog);
	}
	 
}
