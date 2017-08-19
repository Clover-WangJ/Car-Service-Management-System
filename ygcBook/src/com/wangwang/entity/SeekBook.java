package com.wangwang.entity;

public class SeekBook {
	private int seekId;// int identity primary key,
	private String seekName;// varchar(50),
	private String seekAuthor;// varchar(30),
	private String seekPress;//	varchar(30),
	private String seekEmail;//	varchar(30),
	private String seekContext;//	varchar(600)
	
	
	
	public SeekBook() {
		super();
	}



	public SeekBook(String seekName, String seekAuthor, String seekPress,
			String seekEmail, String seekContext) {
		super();
		this.seekName = seekName;
		this.seekAuthor = seekAuthor;
		this.seekPress = seekPress;
		this.seekEmail = seekEmail;
		this.seekContext = seekContext;
	}



	public SeekBook(int seekId, String seekName, String seekAuthor,
			String seekPress, String seekEmail, String seekContext) {
		super();
		this.seekId = seekId;
		this.seekName = seekName;
		this.seekAuthor = seekAuthor;
		this.seekPress = seekPress;
		this.seekEmail = seekEmail;
		this.seekContext = seekContext;
	}



	public int getSeekId() {
		return seekId;
	}



	public void setSeekId(int seekId) {
		this.seekId = seekId;
	}



	public String getSeekName() {
		return seekName;
	}



	public void setSeekName(String seekName) {
		this.seekName = seekName;
	}



	public String getSeekAuthor() {
		return seekAuthor;
	}



	public void setSeekAuthor(String seekAuthor) {
		this.seekAuthor = seekAuthor;
	}



	public String getSeekPress() {
		return seekPress;
	}



	public void setSeekPress(String seekPress) {
		this.seekPress = seekPress;
	}



	public String getSeekEmail() {
		return seekEmail;
	}



	public void setSeekEmail(String seekEmail) {
		this.seekEmail = seekEmail;
	}



	public String getSeekContext() {
		return seekContext;
	}



	public void setSeekContext(String seekContext) {
		this.seekContext = seekContext;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeekBook other = (SeekBook) obj;
		if (seekAuthor == null) {
			if (other.seekAuthor != null)
				return false;
		} else if (!seekAuthor.equals(other.seekAuthor))
			return false;
		if (seekContext == null) {
			if (other.seekContext != null)
				return false;
		} else if (!seekContext.equals(other.seekContext))
			return false;
		if (seekEmail == null) {
			if (other.seekEmail != null)
				return false;
		} else if (!seekEmail.equals(other.seekEmail))
			return false;
		if (seekId != other.seekId)
			return false;
		if (seekName == null) {
			if (other.seekName != null)
				return false;
		} else if (!seekName.equals(other.seekName))
			return false;
		if (seekPress == null) {
			if (other.seekPress != null)
				return false;
		} else if (!seekPress.equals(other.seekPress))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SeekBook [seekAuthor=" + seekAuthor + ", seekContext="
				+ seekContext + ", seekEmail=" + seekEmail + ", seekId="
				+ seekId + ", seekName=" + seekName + ", seekPress="
				+ seekPress + "]";
	}
	
	
	
	
}
