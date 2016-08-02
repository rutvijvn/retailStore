package com.bussvcs.retailstore.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The Entity Class BillItem.
 * @author Rutvij Newaskar
 */
@Entity
@Table(name="bill_item", schema = "retailstore")
public class BillItem implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3126227941290744949L;
	
	/** The bill item id. */
	@Id
	@Column(name="item_id")
	private long billItemId;
	
	/** The product. */
	@OneToOne
	@JoinColumn(name="product_id", referencedColumnName="product_id")
	private Product product;
	
	/** The quantity. */
	@Column(name="quantity")
	private int quantity;
	
	/** The weight. */
	@Column(name="weight")
	private int weight;
	
	/** The base price. */
	@Column(name="base_price")
	private float basePrice;
	
	/** The product discount. */
	@Column(name="product_discount")
	private float productDiscount;
	
	/** The category discount. */
	@Column(name="category_discount")
	private float categoryDiscount;
	
	/** The service tax. */
	@Column(name="service_tax")
	private float serviceTax;
	
	/** The bill. */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="bill_id", referencedColumnName="bill_id")
	private Bill bill;
	
	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	
	/**
	 * Sets the product.
	 *
	 * @param product the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}	
	
	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * Gets the base price.
	 *
	 * @return the base price
	 */
	public float getBasePrice() {
		return basePrice;
	}
	
	/**
	 * Sets the base price.
	 *
	 * @param basePrice the new base price
	 */
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	/**
	 * Gets the product discount.
	 *
	 * @return the product discount
	 */
	public float getProductDiscount() {
		return productDiscount;
	}
	
	/**
	 * Sets the product discount.
	 *
	 * @param productDiscount the new product discount
	 */
	public void setProductDiscount(float productDiscount) {
		this.productDiscount = productDiscount;
	}
	
	/**
	 * Gets the category discount.
	 *
	 * @return the category discount
	 */
	public float getCategoryDiscount() {
		return categoryDiscount;
	}
	
	/**
	 * Sets the category discount.
	 *
	 * @param categoryDiscount the new category discount
	 */
	public void setCategoryDiscount(float categoryDiscount) {
		this.categoryDiscount = categoryDiscount;
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
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Gets the bill.
	 *
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
	}
	
	/**
	 * Sets the bill.
	 *
	 * @param bill the new bill
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	/**
	 * Gets the bill item id.
	 *
	 * @return the bill item id
	 */
	public long getBillItemId() {
		return billItemId;
	}
	
	/**
	 * Sets the bill item id.
	 *
	 * @param billItemId the new bill item id
	 */
	public void setBillItemId(long billItemId) {
		this.billItemId = billItemId;
	}
	
	
}
