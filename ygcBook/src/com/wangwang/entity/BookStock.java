package com.wangwang.entity;

/**
 * ¿â´æ±í
 * @author Administrator
 *
 */
public class BookStock {
	private int stockId;// int identity primary key,
	private int bookId;// int not null,
	private int bookCount;// int not null,
	private int selledCount;// int,
	private int minNum;// int; not null
	
	public BookStock() {
		super();
	}

	public BookStock(int bookId, int bookCount, int selledCount, int minNum) {
		super();
		this.bookId = bookId;
		this.bookCount = bookCount;
		this.selledCount = selledCount;
		this.minNum = minNum;
	}

	public BookStock(int stockId, int bookId, int bookCount, int selledCount,
			int minNum) {
		super();
		this.stockId = stockId;
		this.bookId = bookId;
		this.bookCount = bookCount;
		this.selledCount = selledCount;
		this.minNum = minNum;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getSelledCount() {
		return selledCount;
	}

	public void setSelledCount(int selledCount) {
		this.selledCount = selledCount;
	}

	public int getMinNum() {
		return minNum;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookStock other = (BookStock) obj;
		if (bookCount != other.bookCount)
			return false;
		if (bookId != other.bookId)
			return false;
		if (minNum != other.minNum)
			return false;
		if (selledCount != other.selledCount)
			return false;
		if (stockId != other.stockId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookStock [bookCount=" + bookCount + ", bookId=" + bookId
				+ ", minNum=" + minNum + ", selledCount=" + selledCount
				+ ", stockId=" + stockId + "]";
	}
	
	
	
	
}
