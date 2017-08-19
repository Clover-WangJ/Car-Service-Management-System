package com.wangwang.entity;

import java.util.Date;
/*
 * 图书信息表
 */
public class BookInfo {
	private int bookId ;//int identity primary key,
	private String bookName;// varchar(20) not null,
	private int booktypeId ;//int not null,
	private String pbName;// varchar(20) not null,
	private String author;// varchar(20) not null,
	private String context;// varchar(40) ,
	private String smallImg;// varchar(20) ,
	private String bigImg;// varchar(20) ,
	private double price;// money not null,
	private Date pbdate;// datetime not null,
	private int bookStates;// int not null,--1为可用，2为上架，3为不可用
	private double ygcprice;// money not null
	
	
	public BookInfo() {
		super();
	}


	public BookInfo(String bookName, int booktypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			double price, Date pbdate, int bookStates, double ygcprice) {
		super();
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.bookStates = bookStates;
		this.ygcprice = ygcprice;
	}


	public BookInfo(int bookId, String bookName, int booktypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			double price, Date pbdate, int bookStates, double ygcprice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.booktypeId = booktypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbdate = pbdate;
		this.bookStates = bookStates;
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


	public int getBooktypeId() {
		return booktypeId;
	}


	public void setBooktypeId(int booktypeId) {
		this.booktypeId = booktypeId;
	}


	public String getPbName() {
		return pbName;
	}


	public void setPbName(String pbName) {
		this.pbName = pbName;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getContext() {
		return context;
	}


	public void setContext(String context) {
		this.context = context;
	}


	public String getSmallImg() {
		return smallImg;
	}


	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}


	public String getBigImg() {
		return bigImg;
	}


	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getPbdate() {
		return pbdate;
	}


	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}


	public int getBookStates() {
		return bookStates;
	}


	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}


	public double getYgcprice() {
		return ygcprice;
	}


	public void setYgcprice(double ygcprice) {
		this.ygcprice = ygcprice;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (booktypeId != other.booktypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (pbName == null) {
			if (other.pbName != null)
				return false;
		} else if (!pbName.equals(other.pbName))
			return false;
		if (pbdate == null) {
			if (other.pbdate != null)
				return false;
		} else if (!pbdate.equals(other.pbdate))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		if (Double.doubleToLongBits(ygcprice) != Double
				.doubleToLongBits(other.ygcprice))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BookInfo [author=" + author + ", bigImg=" + bigImg
				+ ", bookId=" + bookId + ", bookName=" + bookName
				+ ", bookStates=" + bookStates + ", booktypeId=" + booktypeId
				+ ", context=" + context + ", pbName=" + pbName + ", pbdate="
				+ pbdate + ", price=" + price + ", smallImg=" + smallImg
				+ ", ygcprice=" + ygcprice + "]" + "\n";
	}
	
	
}
	
	
	
	
	
	
	
