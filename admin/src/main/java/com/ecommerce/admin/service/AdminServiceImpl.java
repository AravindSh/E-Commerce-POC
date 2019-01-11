package com.ecommerce.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.admin.dao.AdminDao;
import com.ecommerce.admin.entity.ProductCatalog;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDao adminDao;

	@Override
	public List<ProductCatalog> getAllProductsByType(String type) {
		return adminDao.getAllProductsByType(type);
	}

	@Override
	public boolean deleteProuctById(String id) {
		return adminDao.deleteProuctById(id);
		
	}

	@Override
	public ProductCatalog getByProductId(String id) {
		return adminDao.getByProductId(id);
	}
	
	@Override
	public ProductCatalog saveProduct(ProductCatalog productCatalog) {
		return adminDao.saveProduct(productCatalog);
	}
	
	@Override
	public ProductCatalog updateProduct(ProductCatalog productCatalog) {
		return adminDao.updateProduct(productCatalog);
	}
	
}
