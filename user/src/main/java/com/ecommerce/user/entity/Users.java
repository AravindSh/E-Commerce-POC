package com.ecommerce.user.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer userid;

	@Column(nullable=false, length=100)
	private String address;

	@Column(nullable=false, length=30)
	private String city;

	@Column(nullable=false, length=30)
	private String country;

	@Column(name="email_address", nullable=false, length=254)
	private String emailAddress;

	@Column(name="first_name", nullable=false, length=30)
	private String firstName;

	@Column(name="last_name", length=30)
	private String lastName;

	@Column(name="password_user", nullable=false, length=64)
	private String passwordUser;

	@Column(name="phone_number", nullable=false, length=15)
	private String phoneNumber;

	@Column(nullable=false, length=6)
	private String zip;

	//bi-directional many-to-one association to OrderDetails
	@OneToMany(mappedBy="user")
	private List<OrderDetails> orderDetails;

	//bi-directional many-to-one association to ShoppingCartItems
	@OneToMany(mappedBy="user")
	private List<ShoppingCartItems> shoppingCartItems;

	//bi-directional many-to-one association to StateTax
	@ManyToOne
	@JoinColumn(name="state", nullable=false)
	private StateTax stateTax;

	public Users() {
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasswordUser() {
		return this.passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<OrderDetails> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetails addOrderDetail(OrderDetails orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setUser(this);

		return orderDetail;
	}

	public OrderDetails removeOrderDetail(OrderDetails orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setUser(null);

		return orderDetail;
	}

	public List<ShoppingCartItems> getShoppingCartItems() {
		return this.shoppingCartItems;
	}

	public void setShoppingCartItems(List<ShoppingCartItems> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	public ShoppingCartItems addShoppingCartItem(ShoppingCartItems shoppingCartItem) {
		getShoppingCartItems().add(shoppingCartItem);
		shoppingCartItem.setUser(this);

		return shoppingCartItem;
	}

	public ShoppingCartItems removeShoppingCartItem(ShoppingCartItems shoppingCartItem) {
		getShoppingCartItems().remove(shoppingCartItem);
		shoppingCartItem.setUser(null);

		return shoppingCartItem;
	}

	public StateTax getStateTax() {
		return this.stateTax;
	}

	public void setStateTax(StateTax stateTax) {
		this.stateTax = stateTax;
	}

}