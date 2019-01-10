package com.ecommerce.admin.service;

import java.util.List;

import com.ecommerce.admin.entity.ProductCatalog;

public interface AdminService {
	List<ProductCatalog> getAllProductsByType(String type);
	public void deleteProuctById(String id);
	ProductCatalog getByProductId(String id);
	void saveProduct(ProductCatalog productCatalog);
	void updateProduct(ProductCatalog productCatalog);
}
