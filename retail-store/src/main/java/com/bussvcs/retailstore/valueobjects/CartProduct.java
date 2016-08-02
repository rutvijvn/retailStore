package com.bussvcs.retailstore.valueobjects;

import java.io.Serializable;

/**
 * The Class CartProduct.
 * @author Rutvij Newaskar
 */
public class CartProduct implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2063857435335781267L;
	
	/** The product id. */
	private long productId;
	
	/** The quantity. */
	private int quantity;
	
	/** The weight. */
	private float weight;
	
	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public long getProductId() {
		return productId;
	}
	
	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(long productId) {
		this.productId = productId;
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
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	
	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
