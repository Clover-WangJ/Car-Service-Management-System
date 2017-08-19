package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.CustomInfo;

public class CustomInfoMapping implements EntityMapping{

	@Override
	public CustomInfo mapping(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		int i = 1;
		CustomInfo customInfo = new CustomInfo(rs.getInt(i++),rs.getDate(i++),
				rs.getString(i++),rs.getDate(i++),rs.getString(i++), rs.getString(i++),
				rs.getString(i++), rs.getString(i++),rs.getDouble(i++),rs.getString(i++),
				rs.getDate(i++),rs.getDate(i++),rs.getInt(i++),rs.getInt(i++),
				rs.getString(i++), rs.getString(i++),rs.getInt(i++),rs.getString(i++), rs.getString(i++),
				rs.getInt(i++),rs.getInt(i++),rs.getInt(i++));
		return customInfo;
	}

}
