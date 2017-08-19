package com.wangwang.entity;


public class OrderInfo {
	private String orderId;
	private String customerName;
	private String consigneeName;
	private float moneyCount ;
	private int bookCount;
	private String mailAddress;
	private String customerTel;
	private int orderStatus ;//订单状态      1  未处理   2  已处理  3 订单完结
	
	public OrderInfo() {
		super();
	}

	
	public OrderInfo(String customerName, String consigneeName,
			float moneyCount, int bookCount, String mailAddress,
			String customerTel, int orderStatus) {
		super();
		this.customerName = customerName;
		this.consigneeName = consigneeName;
		this.moneyCount = moneyCount;
		this.bookCount = bookCount;
		this.mailAddress = mailAddress;
		this.customerTel = customerTel;
		this.orderStatus = orderStatus;
	}


	public OrderInfo(String orderId, String customerName, String consigneeName,
			float moneyCount, int bookCount, String mailAddress,
			String customerTel, int orderStatus) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.consigneeName = consigneeName;
		this.moneyCount = moneyCount;
		this.bookCount = bookCount;
		this.mailAddress = mailAddress;
		this.customerTel = customerTel;
		this.orderStatus = orderStatus;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getConsigneeName() {
		return consigneeName;
	}


	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}


	public float getMoneyCount() {
		return moneyCount;
	}


	public void setMoneyCount(float moneyCount) {
		this.moneyCount = moneyCount;
	}


	public int getBookCount() {
		return bookCount;
	}


	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}


	public String getMailAddress() {
		return mailAddress;
	}


	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}


	public String getCustomerTel() {
		return customerTel;
	}


	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}


	public int getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		if (bookCount != other.bookCount)
			return false;
		if (consigneeName == null) {
			if (other.consigneeName != null)
				return false;
		} else if (!consigneeName.equals(other.consigneeName))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerTel == null) {
			if (other.customerTel != null)
				return false;
		} else if (!customerTel.equals(other.customerTel))
			return false;
		if (mailAddress == null) {
			if (other.mailAddress != null)
				return false;
		} else if (!mailAddress.equals(other.mailAddress))
			return false;
		if (Float.floatToIntBits(moneyCount) != Float
				.floatToIntBits(other.moneyCount))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		return true;
	}

	
	

}