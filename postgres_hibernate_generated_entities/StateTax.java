package ecommerce;

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

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="stateTax")
	private List<Customer> customers;

	//bi-directional many-to-one association to OrderDetail
	@OneToMany(mappedBy="stateTax")
	private List<OrderDetail> orderDetails;

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

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setStateTax(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setStateTax(null);

		return customer;
	}

	public List<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setStateTax(this);

		return orderDetail;
	}

	public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setStateTax(null);

		return orderDetail;
	}

}