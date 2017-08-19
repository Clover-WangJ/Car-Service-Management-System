package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.OrderFullInfo;
import com.wangwang.entity.OrderInfo;
import com.wangwang.mapping.OrderFullMapping;
import com.wangwang.mapping.OrderInfoMapping;

public class OrderInfoDAO {

	
	private Template template = new Template();
	//新增
	public boolean save(OrderInfo orderInfo){
		String sql = "insert into orderInfo" +
				"(orderId,customerName,consigneeName,moneyCount,bookCount," +
				"mailAddress,customerTel,orderStatus)" +
				" values(?,?,?,?,?," +
				"			?,?,?)";
		Object[] values = new Object[]{orderInfo.getOrderId(),orderInfo.getCustomerName(),orderInfo.getConsigneeName(),orderInfo.getMoneyCount(),orderInfo.getBookCount(),
										orderInfo.getMailAddress(),orderInfo.getCustomerTel(),orderInfo.getOrderStatus()};
		int rows = 0;
		try {
			rows = template.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return (rows == 1);
	}
	/*//修改
	public boolean update(OrderInfo orderInfo){
		String sql = "update orderInfo set  " +
					 " customerName=? ," +
					 "consigneeName," +
					 "moneyCount=?, " +
					 "bookCount=? ," +
					 "mailAddress=? ," +
					 "customerTel=? ," +
					 "orderStatus=? " +
					 " where orderId=?";
		Object[] values = new Object[]{orderInfo.getCustomerName(),orderInfo.getConsigneeName(),orderInfo.getMoneyCount(),orderInfo.getBookCount(),
				orderInfo.getMailAddress(),orderInfo.getCustomerTel(),orderInfo.getOrderStatus(),orderInfo.getOrderId()};
		int rows = 0;
		try {
			rows = template.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("未驱动");
		} catch (SQLException e) {
			System.out.println("未连接");
			e.printStackTrace();
		}
		return (rows == 1);
		
	}*/
	
	
	public boolean updateStatus(int status) {
		String sql = "update orderInfo set orderStatus = " + status;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<OrderInfo> findAll() {
		String sql = "select orderId,customerName,consigneeName,moneyCount,bookCount," +
					"mailAddress,customerTel,orderStatus " +
					"	from orderInfo";
		List<OrderInfo> ordes = null;
		try {
			ordes = template.query(sql, new OrderInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordes;
	}
}
