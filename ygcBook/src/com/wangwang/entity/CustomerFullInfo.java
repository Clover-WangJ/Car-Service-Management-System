package com.wangwang.entity;

/**
 * 客户详细信息表
 * @author Administrator
 *
 */
public class CustomerFullInfo {
	private int customerId;// int primary key not null,
	private double countManey;// money,
	private String  tel;// varchar(20),
	private String customerAddress;// varchar(200),
	private int sex;// int not null,
	private int age;// int,
	private int qq;// int
	
	public CustomerFullInfo() {
		super();
	}

	public CustomerFullInfo(double countManey, String tel,
			String customerAddress, int sex, int age, int qq) {
		super();
		this.countManey = countManey;
		this.tel = tel;
		this.customerAddress = customerAddress;
		this.sex = sex;
		this.age = age;
		this.qq = qq;
	}

	public CustomerFullInfo(int customerId, double countManey, String tel,
			String customerAddress, int sex, int age, int qq) {
		super();
		this.customerId = customerId;
		this.countManey = countManey;
		this.tel = tel;
		this.customerAddress = customerAddress;
		this.sex = sex;
		this.age = age;
		this.qq = qq;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getCountManey() {
		return countManey;
	}

	public void setCountManey(double countManey) {
		this.countManey = countManey;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getQq() {
		return qq;
	}

	public void setQq(int qq) {
		this.qq = qq;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerFullInfo other = (CustomerFullInfo) obj;
		if (age != other.age)
			return false;
		if (Double.doubleToLongBits(countManey) != Double
				.doubleToLongBits(other.countManey))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerId != other.customerId)
			return false;
		if (qq != other.qq)
			return false;
		if (sex != other.sex)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerFullInfo [age=" + age + ", countManey=" + countManey
				+ ", customerAddress=" + customerAddress + ", customerId="
				+ customerId + ", qq=" + qq + ", sex=" + sex + ", tel=" + tel
				+ "]";
	}
	
	
}
