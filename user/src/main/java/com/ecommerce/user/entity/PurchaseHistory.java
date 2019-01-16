package com.ecommerce.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the purchase_history database table.
 * 
 */
@Entity
@Table(name="purchase_history")
@NamedQuery(name="PurchaseHistory.findAll", query="SELECT p FROM PurchaseHistory p")
public class PurchaseHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ph_id", unique=true, nullable=false)
	private Integer phId;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_purchase", nullable=false)
	private Date dateOfPurchase;

	@Column(name="inventory_id", nullable=false, length=24)
	private String inventoryId;

	@Column(nullable=false)
	private Integer quantity;

	//bi-directional many-to-one association to OrderDetails
	@ManyToOne
	@JoinColumn(name="ph_order_id")
	private OrderDetails orderDetail;

	public PurchaseHistory() {
	}

	public Integer getPhId() {
		return this.phId;
	}

	public void setPhId(Integer phId) {
		this.phId = phId;
	}

	public Date getDateOfPurchase() {
		return this.dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public String getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public OrderDetails getOrderDetail() {
		return this.orderDetail;
	}

	public void setOrderDetail(OrderDetails orderDetail) {
		this.orderDetail = orderDetail;
	}

}