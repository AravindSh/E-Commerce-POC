package com.ecommerce.admin.dao;

import java.util.List;

import com.ecommerce.admin.entity.ProductCatalog;

public interface AdminDao {
	List<ProductCatalog> getAllProductsByType(String type);
}
