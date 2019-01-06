package com.ecommerce.admin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectId {
	
	@JsonProperty("$oid")
	private String oid;

	public ObjectId() {
		super();
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}
	
}
