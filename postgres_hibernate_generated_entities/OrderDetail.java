package ecommerce;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Entity
@Table(name="order_details")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id", unique=true, nullable=false)
	private Integer orderId;

	@Column(name="rcv_address", length=100)
	private String rcvAddress;

	@Column(name="rcv_city", length=30)
	private String rcvCity;

	@Column(name="rcv_name", length=30)
	private String rcvName;

	@Column(name="rcv_zip", length=6)
	private String rcvZip;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="od_userid")
	private Customer customer;

	//bi-directional many-to-one association to ShippingType
	@ManyToOne
	@JoinColumn(name="od_shipping_type_id")
	private ShippingType shippingType;

	//bi-directional many-to-one association to StateTax
	@ManyToOne
	@JoinColumn(name="rcv_state")
	private StateTax stateTax;

	//bi-directional many-to-one association to PurchaseHistory
	@OneToMany(mappedBy="orderDetail")
	private List<PurchaseHistory> purchaseHistories;

	public OrderDetail() {
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getRcvAddress() {
		return this.rcvAddress;
	}

	public void setRcvAddress(String rcvAddress) {
		this.rcvAddress = rcvAddress;
	}

	public String getRcvCity() {
		return this.rcvCity;
	}

	public void setRcvCity(String rcvCity) {
		this.rcvCity = rcvCity;
	}

	public String getRcvName() {
		return this.rcvName;
	}

	public void setRcvName(String rcvName) {
		this.rcvName = rcvName;
	}

	public String getRcvZip() {
		return this.rcvZip;
	}

	public void setRcvZip(String rcvZip) {
		this.rcvZip = rcvZip;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingType getShippingType() {
		return this.shippingType;
	}

	public void setShippingType(ShippingType shippingType) {
		this.shippingType = shippingType;
	}

	public StateTax getStateTax() {
		return this.stateTax;
	}

	public void setStateTax(StateTax stateTax) {
		this.stateTax = stateTax;
	}

	public List<PurchaseHistory> getPurchaseHistories() {
		return this.purchaseHistories;
	}

	public void setPurchaseHistories(List<PurchaseHistory> purchaseHistories) {
		this.purchaseHistories = purchaseHistories;
	}

	public PurchaseHistory addPurchaseHistory(PurchaseHistory purchaseHistory) {
		getPurchaseHistories().add(purchaseHistory);
		purchaseHistory.setOrderDetail(this);

		return purchaseHistory;
	}

	public PurchaseHistory removePurchaseHistory(PurchaseHistory purchaseHistory) {
		getPurchaseHistories().remove(purchaseHistory);
		purchaseHistory.setOrderDetail(null);

		return purchaseHistory;
	}

}