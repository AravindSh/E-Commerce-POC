package com.ecommerce.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shipping_type database table.
 * 
 */
@Entity
@Table(name="shipping_type")
@NamedQuery(name="ShippingType.findAll", query="SELECT s FROM ShippingType s")
public class ShippingType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shipping_type_id", unique=true, nullable=false, length=30)
	private String shippingTypeId;

	@Column(name="days_for_delivery", nullable=false)
	private Integer daysForDelivery;

	@Column(nullable=false)
	private double price;

	//bi-directional many-to-one association to OrderDetails
	@OneToMany(mappedBy="shippingType")
	private List<OrderDetails> orderDetails;

	public ShippingType() {
	}

	public String getShippingTypeId() {
		return this.shippingTypeId;
	}

	public void setShippingTypeId(String shippingTypeId) {
		this.shippingTypeId = shippingTypeId;
	}

	public Integer getDaysForDelivery() {
		return this.daysForDelivery;
	}

	public void setDaysForDelivery(Integer daysForDelivery) {
		this.daysForDelivery = daysForDelivery;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<OrderDetails> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetails addOrderDetail(OrderDetails orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setShippingType(this);

		return orderDetail;
	}

	public OrderDetails removeOrderDetail(OrderDetails orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setShippingType(null);

		return orderDetail;
	}

}