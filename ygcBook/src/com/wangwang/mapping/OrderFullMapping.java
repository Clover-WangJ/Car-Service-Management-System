package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.OrderFullInfo;

public class OrderFullMapping implements EntityMapping{

	@Override
	public OrderFullInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		OrderFullInfo orderFull = new OrderFullInfo(rs.getInt(i++),rs.getString(i++), rs.getInt(i++), rs.getInt(i++), rs.getDouble(i++), 
													rs.getFloat(i++));
		return orderFull;
	}
	
}
