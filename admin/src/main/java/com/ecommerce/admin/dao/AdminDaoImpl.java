package com.ecommerce.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.admin.entity.ProductCatalog;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private MongoDatabase mongoDatabase;
	private String prodCatCollection = "product_catalog";
	private String TYPE = "type";
	
	private ProductCatalog documentToProdCat(String json) {
		ObjectMapper mapper = new ObjectMapper()
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		ProductCatalog productCatalog = null;
		try {
			productCatalog = mapper.readValue(json, ProductCatalog.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCatalog;
	}
	

	@Override
	public List<ProductCatalog> getAllProductsByType(String type) {
		
		MongoCollection<Document> collection = mongoDatabase.getCollection(prodCatCollection);
		FindIterable<Document> found = collection.find(new Document(TYPE, type));
		List<ProductCatalog> productCatalogs = new ArrayList<>();
		for(Document document:found) {
			productCatalogs.add(documentToProdCat(document.toJson()));		
		}
		return productCatalogs;
	}

}
