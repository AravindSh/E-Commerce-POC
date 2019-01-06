package com.ecommerce.admin.configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoDBConfig {

	private MongoClient mongoClient;
	
	@Value("${mongo.host}")
	private String mongoHost;
	
	@Value("${mongo.port}")
	private int mongoPort;
	
	@Value("${mongo.db}")
	private String dbName;
	
	
	@PostConstruct
	void initMongoClient() {
		mongoClient = new MongoClient(mongoHost, mongoPort);
	}
	
	@PreDestroy
	void closeMongoClient() {
		mongoClient.close();
	}
	
	@Bean
	MongoDatabase getMongoDb() {
		return mongoClient.getDatabase(dbName);
	}
	
}
