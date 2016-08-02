package com.bussvcs.retailstore.data.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The Entity Class User.
 * @author Rutvij Newaskar
 */
@Entity
@Table(name="user", schema = "retailstore")
public class User implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5264879554525052221L;
	
	/** The user id. */
	@Id
	@Column(name="user_id")
	private long userId;
	
	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The mobile number. */
	@Column(name="mobile")
	private String mobileNumber;
	
	/** The email. */
	@Column(name="email")
	private String email;
	
	/** The bills. */
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private List<Bill> bills;
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the mobile number.
	 *
	 * @return the mobile number
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	
	/**
	 * Sets the mobile number.
	 *
	 * @param mobileNumber the new mobile number
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the bills.
	 *
	 * @return the bills
	 */
	public List<Bill> getBills() {
		if(null == this.bills){
			this.bills = new ArrayList<>();
		}
		return this.bills;
	}	
	
}
