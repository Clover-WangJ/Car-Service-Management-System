package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.OrderInfo;

public class OrderInfoMapping implements EntityMapping{

	@Override
	public OrderInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		 OrderInfo  orderInfo = new  OrderInfo(rs.getString(i++),rs.getString(i++), rs.getString(i++), rs.getFloat(i++), rs.getInt(i++),
				 					rs.getString(i++), rs.getString(i++), rs.getInt(i++));
		return orderInfo;
	}
	
}
