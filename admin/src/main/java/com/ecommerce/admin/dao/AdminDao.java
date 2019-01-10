package com.ecommerce.admin.dao;

import java.util.List;

import com.ecommerce.admin.entity.ProductCatalog;

public interface AdminDao {
	List<ProductCatalog> getAllProductsByType(String type);

	void deleteProuctById(String id);

	ProductCatalog getByProductId(String id);

	void saveProduct(ProductCatalog productCatalog);

	void updateProduct(ProductCatalog productCatalog);
}
