package com.bussvcs.retailstore.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The Entity Class Bill.
 * @author Rutvij Newaskar
 */
@Entity
@Table(name="bill", schema = "retailstore")
public class Bill implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8963429872350766328L;

	/** The bill id. */
	@Id
	@Column(name="bill_id")
	private long billId;

	/** The user. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private User user;	

	/** The total sum. */
	@Column(name="sum")
	private float totalSum;

	/** The service tax. */
	@Column(name="service_tax")
	private float serviceTax;

	/** The total discount. */
	@Column(name="total_discout")
	private float totalDiscount;

	/** The bill amount. */
	@Column(name="bill_amount")
	private float billAmount;
	
	/** The bill items. */
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="bill_id", referencedColumnName="bill_id")
	private List<BillItem> billItems;

	/**
	 * Gets the bill id.
	 *
	 * @return the bill id
	 */
	public long getBillId() {
		return billId;
	}

	/**
	 * Sets the bill id.
	 *
	 * @param billId the new bill id
	 */
	public void setBillId(long billId) {
		this.billId = billId;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the total sum.
	 *
	 * @return the total sum
	 */
	public float getTotalSum() {
		return totalSum;
	}

	/**
	 * Sets the total sum.
	 *
	 * @param totalSum the new total sum
	 */
	public void setTotalSum(float totalSum) {
		this.totalSum = totalSum;
	}

	/**
	 * Gets the service tax.
	 *
	 * @return the service tax
	 */
	public float getServiceTax() {
		return serviceTax;
	}

	/**
	 * Sets the service tax.
	 *
	 * @param serviceTax the new service tax
	 */
	public void setServiceTax(float serviceTax) {
		this.serviceTax = serviceTax;
	}

	/**
	 * Gets the total discount.
	 *
	 * @return the total discount
	 */
	public float getTotalDiscount() {
		return totalDiscount;
	}

	/**
	 * Sets the total discount.
	 *
	 * @param totalDiscount the new total discount
	 */
	public void setTotalDiscount(float totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	/**
	 * Gets the bill amount.
	 *
	 * @return the bill amount
	 */
	public float getBillAmount() {
		return billAmount;
	}

	/**
	 * Sets the bill amount.
	 *
	 * @param billAmount the new bill amount
	 */
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * Gets the bill items.
	 *
	 * @return the bill items
	 */
	public List<BillItem> getBillItems() {
		if(null == this.billItems){
			this.billItems = new ArrayList<>();
		}
		return this.billItems;
	}	

}
