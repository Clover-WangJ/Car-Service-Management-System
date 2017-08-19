package com.wangwang.entity;

import java.util.Date;

public class CustomInfo {

	private int id;
	private Date addTime;
	private String address;
	private Date birthday;
	private String carBrand;
	private String carNo;
	private String carType;
	private String cardNo;
	private double charge;
	private String cjh;
	private Date djEndTime;
	private Date djStartTime;
	private int flag;
	private int jf;
	private String name;
	private String phone;
	private int type;
	private String userName;
	private String userPass;
	private int addSeller;
	private int chargeSeller;
	private int activityTimes;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	public String getCjh() {
		return cjh;
	}
	public void setCjh(String cjh) {
		this.cjh = cjh;
	}
	public Date getDjEndTime() {
		return djEndTime;
	}
	public void setDjEndTime(Date djEndTime) {
		this.djEndTime = djEndTime;
	}
	public Date getDjStartTime() {
		return djStartTime;
	}
	public void setDjStartTime(Date djStartTime) {
		this.djStartTime = djStartTime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getJf() {
		return jf;
	}
	public void setJf(int jf) {
		this.jf = jf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getAddSeller() {
		return addSeller;
	}
	public void setAddSeller(int addSeller) {
		this.addSeller = addSeller;
	}
	public int getChargeSeller() {
		return chargeSeller;
	}
	public void setChargeSeller(int chargeSeller) {
		this.chargeSeller = chargeSeller;
	}
	public int getActivityTimes() {
		return activityTimes;
	}
	public void setActivityTimes(int activityTimes) {
		this.activityTimes = activityTimes;
	}
	public CustomInfo(int id, Date addTime, String address, Date birthday,
			String carBrand, String carNo, String carType, String cardNo,
			double charge, String cjh, Date djEndTime, Date djStartTime,
			int flag, int jf, String name, String phone, int type,
			String userName, String userPass, int addSeller, int chargeSeller,
			int activityTimes) {
		super();
		this.id = id;
		this.addTime = addTime;
		this.address = address;
		this.birthday = birthday;
		this.carBrand = carBrand;
		this.carNo = carNo;
		this.carType = carType;
		this.cardNo = cardNo;
		this.charge = charge;
		this.cjh = cjh;
		this.djEndTime = djEndTime;
		this.djStartTime = djStartTime;
		this.flag = flag;
		this.jf = jf;
		this.name = name;
		this.phone = phone;
		this.type = type;
		this.userName = userName;
		this.userPass = userPass;
		this.addSeller = addSeller;
		this.chargeSeller = chargeSeller;
		this.activityTimes = activityTimes;
	}
	public CustomInfo(String phone,String userPass,String name,String carNo,String carType) {
		super();
		this.phone = phone;
		this.userPass = userPass;
		this.name = name;
		this.carNo = carNo;
		this.carType = carType;
	}
	public CustomInfo(String phone,String userPass,String carNo,String carType) {
		super();
		this.phone = phone;
		this.userPass = userPass;

		this.carNo = carNo;
		this.carType = carType;
	}
	public CustomInfo(String phone,String userPass) {
		super();
		this.phone = phone;
		this.userPass = userPass;
	}
	
	
}
