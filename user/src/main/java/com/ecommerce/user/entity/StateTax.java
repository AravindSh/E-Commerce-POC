package com.ecommerce.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_tax database table.
 * 
 */
@Entity
@Table(name="state_tax")
@NamedQuery(name="StateTax.findAll", query="SELECT s FROM StateTax s")
public class StateTax implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="state_name", unique=true, nullable=false, length=30)
	private String stateName;

	@Column(name="sales_tax_rate", nullable=false)
	private double salesTaxRate;

	//bi-directional many-to-one association to OrderDetails
	@OneToMany(mappedBy="stateTax")
	private List<OrderDetails> orderDetails;

	//bi-directional many-to-one association to Users
	@OneToMany(mappedBy="stateTax")
	private List<Users> users;

	public StateTax() {
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public double getSalesTaxRate() {
		return this.salesTaxRate;
	}

	public void setSalesTaxRate(double salesTaxRate) {
		this.salesTaxRate = salesTaxRate;
	}

	public List<OrderDetails> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetails addOrderDetail(OrderDetails orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setStateTax(this);

		return orderDetail;
	}

	public OrderDetails removeOrderDetail(OrderDetails orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setStateTax(null);

		return orderDetail;
	}

	public List<Users> getUsers() {
		return this.users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users addUser(Users user) {
		getUsers().add(user);
		user.setStateTax(this);

		return user;
	}

	public Users removeUser(Users user) {
		getUsers().remove(user);
		user.setStateTax(null);

		return user;
	}

}