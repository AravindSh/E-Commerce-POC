package com.ecommerce.admin.entity;

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
