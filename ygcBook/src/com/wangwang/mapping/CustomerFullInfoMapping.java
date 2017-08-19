package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.CustomerFullInfo;

public class CustomerFullInfoMapping implements EntityMapping {

	@Override
	public CustomerFullInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		
		CustomerFullInfo customerFullInfo = new CustomerFullInfo(rs.getInt(i++),rs.getDouble(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++),
											rs.getInt(i++),rs.getInt(i++));
		
		return customerFullInfo;
	}

}
