package com.ecommerce.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the shopping_cart_items database table.
 * 
 */
@Entity
@Table(name="shopping_cart_items")
@NamedQuery(name="ShoppingCartItems.findAll", query="SELECT s FROM ShoppingCartItems s")
public class ShoppingCartItems implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shopping_cart_id", unique=true, nullable=false)
	private Integer shoppingCartId;

	@Column(name="inventory_id", nullable=false)
	private Integer inventoryId;

	@Column(nullable=false)
	private Integer quantity;

	@Column(name="time_added", nullable=false)
	private Timestamp timeAdded;

	@Column(name="unit_price", nullable=false)
	private double unitPrice;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="sci_userid")
	private Users user;

	public ShoppingCartItems() {
	}

	public Integer getShoppingCartId() {
		return this.shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Timestamp getTimeAdded() {
		return this.timeAdded;
	}

	public void setTimeAdded(Timestamp timeAdded) {
		this.timeAdded = timeAdded;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}