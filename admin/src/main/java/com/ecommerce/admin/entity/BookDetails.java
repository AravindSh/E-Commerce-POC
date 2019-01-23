package com.ecommerce.admin.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDetails {
	
	private String bookName;
	private String author;
	
	public BookDetails() {
		super();
	}
	public BookDetails(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}	

}
