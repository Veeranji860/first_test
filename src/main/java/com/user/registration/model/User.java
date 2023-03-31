package com.user.registration.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "USER_CREDENTIALS")
public class User {
	
	@Column(name = "USER_NAME")
	public String userName;
	@Column(name = "PASSWORD")
	public String password;
	@OneToMany
	@JoinColumn(name = "reg_no",referencedColumnName = "REG_NO")
	public List<Role> role;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public List<Role> getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(List<Role> role) {
		this.role = role;
	}
	

}
