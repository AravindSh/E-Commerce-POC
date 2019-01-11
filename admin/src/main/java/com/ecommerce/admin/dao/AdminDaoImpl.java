package com.ecommerce.admin.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.admin.entity.BookDetails;
import com.ecommerce.admin.entity.ProductCatalog;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private MongoDatabase mongoDatabase;
	private MongoCollection<Document> collection;
	private String prodCatCollection = "product_catalog";
	
	//Constants
	private final String TYPE = "type";
	private final String QUANTITY = "quantity";
	private final String UNIT_PRICE= "unitPrice";
	private final String BOOK_DETAILS = "bookDetails";
	private final String BOOK_NAME = "bookName";
	private final String AUTHOR = "author";
	private final String MONODB_ID = "_id";
	
	@PostConstruct
	public void init() {
		this.collection = mongoDatabase.getCollection(prodCatCollection);
	}

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
		FindIterable<Document> found = collection.find(new Document(TYPE, type));
		List<ProductCatalog> productCatalogs = new ArrayList<>();
		for(Document document:found) {
			productCatalogs.add(documentToProdCat(document.toJson()));		
		}
		return productCatalogs;
	}
	
	@Override
	public boolean deleteProuctById(String id) {
		boolean isDeleted = false;
		Document filter = new Document(MONODB_ID, new ObjectId(id));
		Document found = collection.find(filter).first();
		if(null != found) {
			DeleteResult deleteOne = collection.deleteOne(filter);
			if(deleteOne.getDeletedCount() > 0) {
				isDeleted =  true;
			}
		}
		return isDeleted;
	}
	
	@Override
	public ProductCatalog getByProductId(String id) {
		Document filter = new Document(MONODB_ID, new ObjectId(id));
		Document found = collection.find(filter).first();
		if(found != null) {
			ProductCatalog productCatalog = new ProductCatalog();
			productCatalog = documentToProdCat(found.toJson());
			return productCatalog;
		}else {
			return null;
		}
	}
	
	@Override
	public ProductCatalog saveProduct(ProductCatalog productCatalog) {
		Document document = new Document()
				.append(QUANTITY, productCatalog.getQuantity())
				.append(UNIT_PRICE, productCatalog.getUnitPrice())
				.append(TYPE, productCatalog.getType())
				.append(BOOK_DETAILS, new Document()
							.append(BOOK_NAME, productCatalog.getBookDetails().getBookName())
							.append(AUTHOR, productCatalog.getBookDetails().getAuthor()));
		collection.insertOne(document);
		Document found = collection.find(document).first();
		if(found != null) {
			return documentToProdCat(found.toJson());
		}else {
			return null;
		}
	}
	
	@Override
	public ProductCatalog updateProduct(ProductCatalog productCatalog) {
		Document found = collection.find(new Document(MONODB_ID, new ObjectId(productCatalog.getId().getOid()))).first();
		if(null != found) {
			Document updatedVal = new Document();
			if(null != productCatalog.getQuantity()) {
				updatedVal.append(QUANTITY, productCatalog.getQuantity());
			}
			if(null != productCatalog.getUnitPrice()) {
				updatedVal.append(UNIT_PRICE, productCatalog.getUnitPrice());
			}
			if(null != productCatalog.getType()) {
				updatedVal.append(TYPE, productCatalog.getType());
			}
			BookDetails bookDetails = productCatalog.getBookDetails();
			if(null != bookDetails) {
				if(null != bookDetails.getBookName()) {
					updatedVal.append(BOOK_DETAILS + "." + BOOK_NAME, productCatalog.getBookDetails().getBookName());
				}
				if(null != bookDetails.getAuthor()) {
					updatedVal.append(BOOK_DETAILS + "." + AUTHOR, productCatalog.getBookDetails().getAuthor());
				}
			}
			Document updateOp = new Document("$set", updatedVal);
			collection.updateOne(found, updateOp);
			Document updatedDoc = collection.find(new Document(MONODB_ID, new ObjectId(productCatalog.getId().getOid()))).first();
			return documentToProdCat(updatedDoc.toJson());
		}else {
			return null;
		}
	}

}
