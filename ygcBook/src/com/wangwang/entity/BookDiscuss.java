package com.wangwang.entity;



/**
 *  È∆¿±Ì
 * @author Administrator
 *
 */
public class BookDiscuss {
	private int disId;// int identity primary key,
	private int bookId;// int not null,
	private int customerId;// int not null,
	private int states;// int not null,
	private String context;// varchar(8000) not null,
	
	
	public BookDiscuss() {
		super();
	}


	public BookDiscuss(int bookId, int customerId, int states, String context) {
		super();
		this.bookId = bookId;
		this.customerId = customerId;
		this.states = states;
		this.context = context;
	}


	public BookDiscuss(int disId, int bookId, int customerId, int states,
			String context) {
		super();
		this.disId = disId;
		this.bookId = bookId;
		this.customerId = customerId;
		this.states = states;
		this.context = context;
	}


	public int getDisId() {
		return disId;
	}


	public void setDisId(int disId) {
		this.disId = disId;
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


	public int getStates() {
		return states;
	}


	public void setStates(int states) {
		this.states = states;
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
		BookDiscuss other = (BookDiscuss) obj;
		if (bookId != other.bookId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (customerId != other.customerId)
			return false;
		if (disId != other.disId)
			return false;
		if (states != other.states)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "BookDiscuss [bookId=" + bookId + ", context=" + context
				+ ", customerId=" + customerId + ", disId=" + disId
				+ ", states=" + states + "]";
	}
	
	
	
}
