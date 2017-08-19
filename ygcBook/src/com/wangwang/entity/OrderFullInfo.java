package com.wangwang.entity;

public class OrderFullInfo {
	private int orderFullId;
	private String orderId;//���
	private int bookId;//ͼ����
	private int bookNum;//ͼ����������
	private double bookOldPrice;//����ʱ�ĵ���
	private float bookCountPrive;//�ܼ�
	
	
	public OrderFullInfo() {
		super();
	}

	

	public OrderFullInfo(String orderId, int bookId, int bookNum,
			double bookOldPrice, float bookCountPrive) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.bookNum = bookNum;
		this.bookOldPrice = bookOldPrice;
		this.bookCountPrive = bookCountPrive;
	}



	public OrderFullInfo(int orderFullId, String orderId, int bookId,
			int bookNum, double bookOldPrice, float bookCountPrive) {
		super();
		this.orderFullId = orderFullId;
		this.orderId = orderId;
		this.bookId = bookId;
		this.bookNum = bookNum;
		this.bookOldPrice = bookOldPrice;
		this.bookCountPrive = bookCountPrive;
	}



	public int getOrderFullId() {
		return orderFullId;
	}

	public void setOrderFullId(int orderFullId) {
		this.orderFullId = orderFullId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookNum() {
		return bookNum;
	}

	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public double getBookOldPrice() {
		return bookOldPrice;
	}

	public void setBookOldPrice(double bookOldPrice) {
		this.bookOldPrice = bookOldPrice;
	}

	public float getBookCountPrive() {
		return bookCountPrive;
	}

	public void setBookCountPrive(float bookCountPrive) {
		this.bookCountPrive = bookCountPrive;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderFullInfo other = (OrderFullInfo) obj;
		if (Float.floatToIntBits(bookCountPrive) != Float
				.floatToIntBits(other.bookCountPrive))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookNum != other.bookNum)
			return false;
		if (Double.doubleToLongBits(bookOldPrice) != Double
				.doubleToLongBits(other.bookOldPrice))
			return false;
		if (orderFullId != other.orderFullId)
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
	
	
}
