package com.wangwang.entity;



/**
 * 图书类别表
 * @author Administrator
 *
 */
public class BookType {
	private int bookTypeId;// int identity primary key,
	private int isDelete;//	int not null, --1可用 2删除的
	private int parentId;//	int not null,
	private String bookTypeName ;//varchar(20) not null,
	private String context ;//varchar(40)
	
	
	
	public BookType() {
		super();
	}
	public BookType(int isDelete, int parentId, String bookTypeName,
			String context) {
		super();
		this.isDelete = isDelete;
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
	}
	public BookType(int bookTypeId, int isDelete, int parentId,
			String bookTypeName, String context) {
		super();
		this.bookTypeId = bookTypeId;
		this.isDelete = isDelete;
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
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
		BookType other = (BookType) obj;
		if (bookTypeId != other.bookTypeId)
			return false;
		if (bookTypeName == null) {
			if (other.bookTypeName != null)
				return false;
		} else if (!bookTypeName.equals(other.bookTypeName))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (isDelete != other.isDelete)
			return false;
		if (parentId != other.parentId)
			return false;
		return true;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "BookType [bookTypeId=" + bookTypeId + ", isDelete=" + isDelete
				+ ", parentId=" + parentId + ", bookTypeName=" + bookTypeName
				+ ", context=" + context +"]" +"\n";
	}
	
	
	
}
