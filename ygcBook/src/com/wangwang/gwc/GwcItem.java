package com.wangwang.gwc;

public class GwcItem {
	
	private int bookId;
	private String bookName;
	private double price;
	private double ygcprice;
	private int num;//¹ºÂòÊýÁ¿
	
	public GwcItem() {
		super();
	}
	
	public GwcItem(int bookId, String bookName, double price, double ygcprice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.ygcprice = ygcprice;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getYgcprice() {
		return ygcprice;
	}

	public void setYgcprice(double ygcprice) {
		this.ygcprice = ygcprice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + num;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ygcprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GwcItem other = (GwcItem) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (num != other.num)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(ygcprice) != Double
				.doubleToLongBits(other.ygcprice))
			return false;
		return true;
	}
	
	

}
