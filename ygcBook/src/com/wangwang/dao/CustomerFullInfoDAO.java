package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.CustomerFullInfo;
import com.wangwang.mapping.CustomerFullInfoMapping;

public class CustomerFullInfoDAO {
	
	private Template template = new Template();
	
	public boolean save(CustomerFullInfo fullInfo) {
		
		String sql = "insert into customerFullInfo" +
					"	(customerId,countManey,tel,customerAddress,sex," +
					"	age,qq) "+ 
					"values" +
					"	(?,?,?,?,?" +
					"	?,?)";
		Object[] values = {fullInfo.getCustomerId(),fullInfo.getCountManey(),fullInfo.getTel(),fullInfo.getCustomerAddress(),fullInfo.getSex(),
							fullInfo.getAge(),fullInfo.getQq()};
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(CustomerFullInfo fullInfo) {
		
		String sql = "update customerFullInfo" +
					"set " +
					"	customerId = ?," +
					"	countManey = ?," +
					"	tel =?," +
					"	customerAddress = ?," +
					"	sex = ?" +
					"	age = ?," +
					"	qq  = ?"+ 
					"where customerId = ?";
			
		Object[] values = {fullInfo.getCustomerId(),fullInfo.getCountManey(),fullInfo.getTel(),fullInfo.getCustomerAddress(),fullInfo.getSex(),
							fullInfo.getAge(),fullInfo.getQq(),fullInfo.getCustomerId()};
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		
		String sql = "delete from customerFullInfo where customerId = " + id;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public List<CustomerFullInfo> findAll() {
		String sql = "select " + 
					"	customerId,countManey,tel,customerAddress,sex," +
					"	age,qq "+
					" from customerFullInfo";
		List<CustomerFullInfo> customerFullInfos = null;
		
		try {
			customerFullInfos = template.query(sql, new CustomerFullInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerFullInfos;
	}
	
	public CustomerFullInfo findById(int id) {
		String sql = "select " + 
					"	customerId,countManey,tel,customerAddress,sex," +
					"	age,qq "+
					" from customerFullInfo	" +
					"	where customerId = " + id;
		
		CustomerFullInfo cusFull = null;
		List<CustomerFullInfo> customerFullInfos = null;
		
		try {
			customerFullInfos = template.query(sql, new CustomerFullInfoMapping());
			if (customerFullInfos.size() != 0) {
				cusFull = customerFullInfos.get(0);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cusFull;
	}
	
}
