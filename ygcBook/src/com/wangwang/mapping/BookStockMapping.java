package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookStock;

public class BookStockMapping implements EntityMapping {

	@Override
	public BookStock mapping(ResultSet rs) throws SQLException {
		
		int i = 1;
		BookStock bookStock = new BookStock(rs.getInt(i++),rs.getInt(i++),rs.getInt(i++),rs.getInt(i++),rs.getInt(i++));
		
		return bookStock;
	}

}
