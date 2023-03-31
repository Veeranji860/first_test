package com.user.registration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name = "ADDRESS_DETAILS")
@DynamicUpdate
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ADDR_ID")
	private Integer addrID;
	@Column(name = "ADDR1")
	private String addrLine1;
	@Column(name = "ADDR2")
	private String addrLine2;
	@Column(name = "ADDR3")
	private String addrLine3;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "POSTEL_CODE")
	private String postelCode;

	/**
	 * @return the userID
	 */
	public Integer getAddrID() {
		return addrID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer addrID) {
		this.addrID = addrID;
	}
	/**
	 * @return the addrLine1
	 */
	public String getAddrLine1() {
		return addrLine1;
	}
	/**
	 * @param addrLine1 the addrLine1 to set
	 */
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	/**
	 * @return the addrLine2
	 */
	public String getAddrLine2() {
		return addrLine2;
	}
	/**
	 * @param addrLine2 the addrLine2 to set
	 */
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	/**
	 * @return the addrLine3
	 */
	public String getAddrLine3() {
		return addrLine3;
	}
	/**
	 * @param addrLine3 the addrLine3 to set
	 */
	public void setAddrLine3(String addrLine3) {
		this.addrLine3 = addrLine3;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the postelCode
	 */
	public String getPostelCode() {
		return postelCode;
	}
	/**
	 * @param postelCode the postelCode to set
	 */
	public void setPostelCode(String postelCode) {
		this.postelCode = postelCode;
	}
	/**
	 * @param addrID the addrID to set
	 */
	public void setAddrID(Integer addrID) {
		this.addrID = addrID;
	}
	
	

}
