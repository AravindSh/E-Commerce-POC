package com.ecommerce.mongodbDataInit;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductReview {
	@JsonProperty("_id")
	private ObjectId id;
	//fk to ProductCatalog
	private String productCatalogId;
	private String review;
	private int rating;
	private Date reviewDate;
	//fk to customer - Postgres
	private int userId;
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProductCatalogId() {
		return productCatalogId;
	}
	public void setProductCatalogId(String productCatalogId) {
		this.productCatalogId = productCatalogId;
	}
	
	

}
