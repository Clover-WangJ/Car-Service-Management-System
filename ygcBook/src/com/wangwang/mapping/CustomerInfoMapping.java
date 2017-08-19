package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.CustomerInfo;

public class CustomerInfoMapping implements EntityMapping {

	@Override
	public CustomerInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		
		CustomerInfo customerInfo = new CustomerInfo(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++));
		
		return customerInfo;
	}

}
