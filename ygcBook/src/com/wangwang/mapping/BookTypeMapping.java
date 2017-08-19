package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookType;

public class BookTypeMapping implements EntityMapping {

	@Override
	public BookType mapping(ResultSet rs) throws SQLException {
		int i = 1;
		BookType bookType = new BookType(rs.getInt(i++),rs.getInt(i++),rs.getInt(i++),rs.getString(i++),rs.getString(i++));
		
		
		return bookType;
		
	}
	
}
