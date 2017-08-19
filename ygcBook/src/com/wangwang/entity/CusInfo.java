package com.wangwang.entity;

import java.util.Date;

public class CusInfo {

	private int customerId;
	private String customerName;
	private String pwd;
	private String tel;
	private int sex;
	private int age;
	private int qq;
	private Double countManey;
	private String customerAddress;
	private String email;
	private Date addTime;
	private Date birthday;
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public Double getCountManey() {
		return countManey;
	}
	public void setCountManey(Double countManey) {
		this.countManey = countManey;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public CusInfo(int customerId, String customerName, String pwd, String tel,
			int sex, int age, int qq, Double countManey,
			String customerAddress, String email, Date addTime, Date birthday) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.pwd = pwd;
		this.tel = tel;
		this.sex = sex;
		this.age = age;
		this.qq = qq;
		this.countManey = countManey;
		this.customerAddress = customerAddress;
		this.email = email;
		this.addTime = addTime;
		this.birthday = birthday;
	}
	public CusInfo(String tel,String customerName,String pwd) {
		super();
		this.tel = tel;
		this.customerName = customerName;
		this.pwd = pwd;
	}
	
}
