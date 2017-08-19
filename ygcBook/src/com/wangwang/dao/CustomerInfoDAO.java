package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.CustomerInfo;
import com.wangwang.mapping.CustomerInfoMapping;

public class CustomerInfoDAO {
	
	private Template template = new Template();
	
	public boolean save(CustomerInfo customerInfo) {
		
		String sql = "insert into customerInfo" +
				"	(customerName,pwd,email)" +
				"values " +
				"	(?,?,?)";
		
		try {
			return (template.update(sql,customerInfo.getCustomerName(),
					customerInfo.getPwd(),customerInfo.getEmail()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(CustomerInfo customerInfo) {
		
		String sql = "update customerInfo" +
					"set" +
					"	customerName =?," +
					"	pwd = ?," +
					"	email = ?" +
					"where customerId = ?" ;
		
		try {
			return (template.update(sql,customerInfo.getCustomerName(),
					customerInfo.getPwd(),customerInfo.getEmail(),customerInfo.getCustomerId()) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id) {
		String sql = "delete from customerInfo where customerId = " + id;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<CustomerInfo> findAll() {
		
		String sql = "select customerId,customerName,pwd,email from customerInfo ";
		List<CustomerInfo> customerInfos = null;
		
		try {
			customerInfos = template.query(sql, new CustomerInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerInfos;
	}
	
public CustomerInfo findById(int id) {
		
		String sql = "select customerId,customerName,pwd,email from customerInfo where customerId = " + id;
		List<CustomerInfo> customerInfos = null;
		
		try {
			customerInfos = template.query(sql, new CustomerInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerInfos.get(0);
	}
	

public CustomerInfo getNameAndPwd(String name, String pwd) {
	
	String sql = "select customerId,customerName,pwd,email from customerInfo where customerName = ? and pwd = ?" ;
	List<CustomerInfo> customerInfos = null;
	CustomerInfo customerInfo = null;
	
	try {
		customerInfos = template.query(sql, new CustomerInfoMapping(),name, pwd);
		if (customerInfos.size()!= 0) {
			customerInfo = customerInfos.get(0);
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return customerInfo;
}
}
