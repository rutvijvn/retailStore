package com.bussvcs.retailstore.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The Entity Class ProductCategory.
 * @author Rutvij Newaskar
 */
@Entity
@Table(name="product_Category", schema = "retailstore")
public class ProductCategory implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2458555109149442675L;

	/** The product category id. */
	@Id
	@Column(name="category_id")
	private long productCategoryId;	

	/** The category name. */
	@Column(name="category_name")
	private String categoryName;
	
	/** The products. */
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="category_id", referencedColumnName="category_id")
	private List<Product> products;
	
	/** The service tax. */
	@Column(name="service_tax")
	private float serviceTax; 
	
	/** The discount. */
	@Column(name="discount")
	private float discount; 
	
	/**
	 * Gets the product category id.
	 *
	 * @return the product category id
	 */
	public long getProductCategoryId() {
		return productCategoryId;
	}

	/**
	 * Sets the product category id.
	 *
	 * @param productCategoryId the new product category id
	 */
	public void setProductCategoryId(long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	/**
	 * Gets the category name.
	 *
	 * @return the category name
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * Sets the category name.
	 *
	 * @param categoryName the new category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	public List<Product> getProducts() {
		if(null == this.products){
			this.products = new ArrayList<>();
		}
		return this.products;
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
}
