package com.ecommerce.admin.dto;

import com.ecommerce.admin.entity.BookDetails;

public class ProductCatalogDTO {

	private int quantity;
	private double unitPrice;
	private String type;
	private BookDetails bookDetails;
	
	public ProductCatalogDTO(int quantity, double unitPrice, String type, BookDetails bookDetails) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.type = type;
		this.bookDetails = bookDetails;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
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
