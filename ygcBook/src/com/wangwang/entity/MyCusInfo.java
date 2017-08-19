package com.wangwang.entity;

import java.util.Date;

public class MyCusInfo {
	
	private int telNum ;
	private int validCode ;
	private String userName ;
	private String carNum ;
	private int type ;
	private String passCode;
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
	public int getTelNum() {
		return telNum;
	}
	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}
	public int getValidCode() {
		return validCode;
	}
	public void setValidCode(int validCode) {
		this.validCode = validCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPassCode() {
		return passCode;
	}
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}
	public MyCusInfo(int telNum, int validCode, String userName, String carNum , int type , String passCode ) {
		super();
		this.telNum = telNum;
		this.validCode = validCode;
		this.userName = userName;
		this.carNum = carNum;
		this.type = type;
		this.passCode = passCode;
	}
	public MyCusInfo() {
		
	}
	
	
}
