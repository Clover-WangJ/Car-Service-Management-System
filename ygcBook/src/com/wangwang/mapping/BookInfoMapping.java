package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookInfo;

public class BookInfoMapping implements EntityMapping{

	@Override
	public BookInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		BookInfo bookInfo = new BookInfo(rs.getInt(i++),rs.getString(i++),rs.getInt(i++),rs.getString(i++),rs.getString(i++),
					rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getDouble(i++),rs.getDate(i++),
					rs.getInt(i++),rs.getDouble(i++));
		
		
		
		
		return bookInfo;
		
	}
	
}
