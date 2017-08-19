package com.wangwang.entity;


/**
 * ¿Í»§×¢²á±í
 * @author Administrator
 *
 */
public class CustomerInfo {
	private int customerId;//int identity primary key,
	private String customerName;// varchar(20) not null,
	private String email;// varchar(50) not null,
	private String pwd;// varchar(20) not null
	
	
	public CustomerInfo() {
		super();
	}


	public CustomerInfo(String customerName, String email, String pwd) {
		super();
		this.customerName = customerName;
		this.email = email;
		this.pwd = pwd;
	}


	public CustomerInfo(int customerId, String customerName, String email,
			String pwd) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.pwd = pwd;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerInfo other = (CustomerInfo) obj;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CustomerInfo [customerId=" + customerId + ", customerName="
				+ customerName + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
}
