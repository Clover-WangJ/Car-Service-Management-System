package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.SeekBook;

public class SeekBookMapping implements EntityMapping{

	@Override
	public SeekBook mapping(ResultSet rs) throws SQLException {
		int i = 1;
		
		SeekBook seekBook = new SeekBook(rs.getInt(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),
					rs.getString(i++));
		return seekBook;
	}

}
