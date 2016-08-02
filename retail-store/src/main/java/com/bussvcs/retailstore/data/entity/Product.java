package com.bussvcs.retailstore.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * The Entity Class Product.
 * @author Rutvij Newaskar
 */
@Entity
@Table(name="product", schema = "retailstore")
public class Product implements Serializable{	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -723957313086330222L;

	/** The product id. */
	@Id	
	@Column(name="product_id", nullable=false)
	private Long productId; 
	
	/** The product name. */
	@Column(name="product_name")
	private String productName;
	
	/** The bar code. */
	@Column(name="barcode")
	private Long barCode;	
	
	/** The product category. */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id", referencedColumnName="category_id")
	private ProductCategory productCategory;
	
	/** The base price. */
	@Column(name="base_price")
	private float basePrice;
	
	/** The discount. */
	@Column(name="discount")
	private float discount;
	
	/** The weight. */
	@Column(name="weight")
	private int weight;

	/**
	 * Gets the product category.
	 *
	 * @return the product category
	 */
	public ProductCategory getProductCategory() {
		return productCategory;
	}

	/**
	 * Sets the product category.
	 *
	 * @param productCategory the new product category
	 */
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * Gets the discount.
	 *
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * Sets the discount.
	 *
	 * @param discount the new discount
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the bar code.
	 *
	 * @return the bar code
	 */
	public Long getBarCode() {
		return barCode;
	}

	/**
	 * Sets the bar code.
	 *
	 * @param barCode the new bar code
	 */
	public void setBarCode(Long barCode) {
		this.barCode = barCode;
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
	
	
	
}
