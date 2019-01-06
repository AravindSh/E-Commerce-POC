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
	
}
