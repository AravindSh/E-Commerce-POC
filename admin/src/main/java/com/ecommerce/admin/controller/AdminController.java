package com.ecommerce.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	//Constants
	private final String TECHNICAL_ERROR = "Technical Error";

	@GetMapping("/ping")
	public ResponseEntity<?> ping() {
		String ping = appName+"|"+springProfile;
		try {
			return new ResponseEntity<>(ping, HttpStatus.OK);
		}catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products")
	ResponseEntity<?> getProductsByType(@RequestParam String type) {
		try {
			List<ProductCatalog> products = adminService.getAllProductsByType(type);
			if(null != products && !products.isEmpty()) {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products/{productId}")
	ResponseEntity<?> getByProductId(@PathVariable String productId) {
		try {
			ProductCatalog product = adminService.getByProductId(productId);
			if(null != product) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/products/{productId}")
	ResponseEntity<?> deleteProuctById(@PathVariable String productId) {
		try {
			boolean isDeleted = adminService.deleteProuctById(productId);
			if(isDeleted) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/products")	
	ResponseEntity<?> saveProduct(@RequestBody ProductCatalog productCatalog) {
		try {
			ProductCatalog productNew = adminService.saveProduct(productCatalog);
			if(null != productNew) {
				HttpHeaders headers = new HttpHeaders();
				String url = "/products/" + productNew.getId().getOid();
				headers.add("Location", url);
				return new ResponseEntity<>(productNew, headers, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("Failed to Save", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/products/{productId}")
	ResponseEntity<?> updateProduct(@RequestBody ProductCatalog productCatalog, @PathVariable String productId) {
		try {
			ObjectId id = new ObjectId();
			id.setOid(productId);
			productCatalog.setId(id);
			ProductCatalog updatedProd = adminService.updateProduct(productCatalog);
			if(null != updatedProd) {
				return new ResponseEntity<>(updatedProd, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(TECHNICAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
}
