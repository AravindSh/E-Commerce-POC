package com.ecommerce.mongodbDataInit;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class MongodbDataInit 
{
	private static MongoClient mongoClient = null;
	
	private static void entrySetup() {
		mongoClient = new MongoClient("localhost", 27017);
	}
	
	private static void exitSetup() {
		mongoClient.close();
	}
	
		
    public static void main( String[] args )
    {
    	entrySetup();
    	MongoDatabase database = mongoClient.getDatabase("e_commerce_db");
		MongoCollection<Document> productCatalogCollection = database.getCollection("product_catalog");
		initProductCatalog(productCatalogCollection);
    	displayProductCatalog(productCatalogCollection);
    	exitSetup();
    }

	private static void displayProductCatalog(MongoCollection<Document> productCatalogCollection) {
		Block<Document> printBlock = document -> System.out.println(document.toJson());
		productCatalogCollection.find().forEach(printBlock);
	}

	private static void initProductCatalog(MongoCollection<Document> prodCatCollection) {
		List<ProductCatalog> productCatalogs = Arrays.asList(new ProductCatalog(10, 100, "book", new BookDetails("Java", "Herbert Schildt")),
				new ProductCatalog(15, 150, "books", new BookDetails("The Monk Who Sold his Ferari", "Robin Sharma")),
				new ProductCatalog(25, 200, "books", new BookDetails("Rich Dad Poor Dad", "Robert Kiyosaki")),
				new ProductCatalog(5, 2000, "books", new BookDetails("Harry Potter", "J K Rowling")),
				new ProductCatalog(50, 1000, "books", new BookDetails("Bhagwad Gita", "Krishna"))
				);
		for(ProductCatalog productCatalog: productCatalogs) {
			Document productCatalogDoc = new Document()
					.append("quantity", productCatalog.getQuantity())
					.append("unitPrice", productCatalog.getUnitPrice())
					.append("type", productCatalog.getType())
					.append("bookDetails", new Document().append("bookName", productCatalog.getBookDetails().getBookName())
														.append("author", productCatalog.getBookDetails().getAuthor()));
			prodCatCollection.insertOne(productCatalogDoc);
		}
	}
}
