package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.AdminInfo;
import com.wangwang.entity.CusInfo;

public class CusInfoMapping implements EntityMapping{

	@Override
	public CusInfo mapping(ResultSet rs) throws SQLException {

		int i = 1;
		CusInfo cusInfo = new CusInfo(rs.getInt(i++), rs.getString(i++),
				rs.getString(i++), rs.getString(i++), rs.getInt(i++),
				rs.getInt(i++), rs.getInt(i++), rs.getDouble(i++), 
				rs.getString(i++),rs.getString(i++), 
				rs.getDate(i++), rs.getDate(i++));
		return cusInfo;
	}

	
}
