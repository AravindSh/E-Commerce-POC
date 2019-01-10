package com.ecommerce.admin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductCatalog {
	
	@JsonProperty("_id")
	private ObjectId id;
	private Integer quantity;
	private Double unitPrice;
	private String type;
	private BookDetails bookDetails;
	
	public ProductCatalog() {
		super();
	}

	public ProductCatalog(Integer quantity, Double unitPrice, String type, BookDetails bookDetails) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.type = type;
		this.bookDetails = bookDetails;
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BookDetails getBookDetails() {
		return bookDetails;
	}
	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}

}
