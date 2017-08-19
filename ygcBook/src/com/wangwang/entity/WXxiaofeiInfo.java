package com.wangwang.entity;

import java.util.Date;

public class WXxiaofeiInfo {

	private String cname;
	private String cphone;
	private String srname;
	private String sname;
	private Date addTime;
	private double money;
	private double jf;
	private int f;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getSrname() {
		return srname;
	}
	public void setSrname(String srname) {
		this.srname = srname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getJf() {
		return jf;
	}
	public void setJf(double jf) {
		this.jf = jf;
	}
	public int getF() {
		return f;
	}
	public void setF(int f) {
		this.f = f;
	}
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
	public WXxiaofeiInfo(String cname, String cphone, String srname,
			String sname, Date addTime, double money, double jf, int f) {
		super();
		this.cname = cname;
		this.cphone = cphone;
		this.srname = srname;
		this.sname = sname;
		this.addTime = addTime;
		this.money = money;
		this.jf = jf;
		this.f = f;
	}
	public WXxiaofeiInfo() {
		super();
	
	}
	
	
}
