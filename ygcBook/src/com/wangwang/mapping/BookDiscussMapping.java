package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookDiscuss;

public class BookDiscussMapping implements EntityMapping {

	@Override
	public BookDiscuss mapping(ResultSet rs) throws SQLException {
		int i = 1;
		BookDiscuss bookDiscuss = new BookDiscuss(rs.getInt(i++),rs.getInt(i++),rs.getInt(i++),rs.getInt(i++),rs.getString(i++));
		return bookDiscuss;
	}

}
