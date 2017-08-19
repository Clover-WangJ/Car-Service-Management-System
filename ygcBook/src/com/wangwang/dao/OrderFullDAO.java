package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.OrderFullInfo;
import com.wangwang.mapping.OrderFullMapping;

public class OrderFullDAO {
	private Template template = new Template();
	
	public boolean save(OrderFullInfo order) {
		String sql =  "insert into orderFullInfo " +
					"(orderId,bookId,bookNum,bookOldPrice,bookCountPrive)" +
					"  values " +
					"(?,?,?,?,?)";
		Object[] values = {order.getOrderId(),order.getBookId(),order.getBookNum(),order.getBookOldPrice(),order.getBookCountPrive()};
	
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
/*	public boolean saveList(List<OrderFullInfo> ordes) {
		String sql =  "insert into orderFullInfo " +
		"(orderId,bookId,bookNum,bookOldPrice,bookCountPrive)" +
		"  values " +
		"(?,?,?,?,?)";
		return null;
	}
	*/
	
	
	

	public List<OrderFullInfo> findById(String orderId) {
		String sql = "select orderFullId,orderId,bookId,bookNum,bookOldPrice,bookCountPrive " +
					"	from orderFullInfo where orderId = ?";
		List<OrderFullInfo> ordes = null;
		try {
			ordes = template.query(sql, new OrderFullMapping() , orderId);
			System.out.println(ordes);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordes;
	}
}
