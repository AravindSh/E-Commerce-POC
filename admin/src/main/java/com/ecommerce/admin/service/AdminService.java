package com.ecommerce.admin.service;

import java.util.List;

import com.ecommerce.admin.entity.ProductCatalog;

public interface AdminService {
	List<ProductCatalog> getAllProductsByType(String type);
	boolean deleteProuctById(String id);
	ProductCatalog getByProductId(String id);
	ProductCatalog saveProduct(ProductCatalog productCatalog);
	ProductCatalog updateProduct(ProductCatalog productCatalog);
}
