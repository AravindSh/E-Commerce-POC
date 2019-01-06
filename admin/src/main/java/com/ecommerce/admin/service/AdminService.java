package com.ecommerce.admin.service;

import java.util.List;

import com.ecommerce.admin.entity.ProductCatalog;

public interface AdminService {
	List<ProductCatalog> getAllProductsByType(String type);
}
