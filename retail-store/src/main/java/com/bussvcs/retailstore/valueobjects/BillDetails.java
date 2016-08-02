package com.bussvcs.retailstore.valueobjects;

import java.util.ArrayList;
import java.util.List;

import com.bussvcs.retailstore.data.entity.User;

/**
 * The Class BillDetails.
 * @author Rutvij Newaskar
 */
public class BillDetails {

	/** The product list. */
	private List<CartProduct> productList;
	
	/** The user. */
	private User user;
	
	/**
	 * Gets the product list.
	 *
	 * @return the product list
	 */
	public List<CartProduct> getProductList(){
		if(null == this.productList){
			this.productList = new ArrayList<>();			
		}
		return this.productList;
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
	
}
