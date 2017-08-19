package com.wangwang.entity;

/**
 * 管理员信息表
 * @author Administrator
 *
 */
public class AdminInfo {
	private int adminId;// int identity primary key,
	private String adminName;// varchar(20) not null,
	private String adminPassword;// varchar(20) not null,
	private int adminType;// int
	
	public AdminInfo() {
		super();
	}

	public AdminInfo(String adminName, String adminPassword, int adminType) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminType = adminType;
	}

	public AdminInfo(int adminId, String adminName, String adminPassword,
			int adminType) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminType = adminType;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getAdminType() {
		return adminType;
	}

	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminInfo other = (AdminInfo) obj;
		if (adminId != other.adminId)
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		if (adminPassword == null) {
			if (other.adminPassword != null)
				return false;
		} else if (!adminPassword.equals(other.adminPassword))
			return false;
		if (adminType != other.adminType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", adminName=" + adminName
				+ ", adminPassword=" + adminPassword + ", adminType="
				+ adminType + "]";
	}
	
	
	
}
