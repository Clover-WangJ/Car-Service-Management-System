package com.wangwang.entity;

import java.util.Date;

/**
 * 收藏夹信息表
 * @author Administrator
 *
 */
public class FavoritesInfo {
	private int favoritesId;// int identity primary key,
	private int bookId;// int not null,
	private int customerId;// int not null,
	private Date date;// datetime not null,
	private String context;// varchar(800)
	
	public FavoritesInfo() {
		super();
	}

	public FavoritesInfo(int bookId, int customerId, Date date, String context) {
		super();
		this.bookId = bookId;
		this.customerId = customerId;
		this.date = date;
		this.context = context;
	}

	public FavoritesInfo(int favoritesId, int bookId, int customerId,
			Date date, String context) {
		super();
		this.favoritesId = favoritesId;
		this.bookId = bookId;
		this.customerId = customerId;
		this.date = date;
		this.context = context;
	}

	public int getFavoritesId() {
		return favoritesId;
	}

	public void setFavoritesId(int favoritesId) {
		this.favoritesId = favoritesId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoritesInfo other = (FavoritesInfo) obj;
		if (bookId != other.bookId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (customerId != other.customerId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (favoritesId != other.favoritesId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FavoritesInfo [bookId=" + bookId + ", context=" + context
				+ ", customerId=" + customerId + ", date=" + date
				+ ", favoritesId=" + favoritesId + "]";
	}
	
	
	
}
