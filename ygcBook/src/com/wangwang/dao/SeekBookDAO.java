package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;


import com.wangwang.db.Template;
import com.wangwang.entity.SeekBook;
import com.wangwang.mapping.SeekBookMapping;

public class SeekBookDAO {
	
	private Template template = new Template();

	public boolean save(SeekBook seekBook) {
		String sql = "insert into seekBook" +
					"	(seekName,seekAuthor,seekPress,seekEmail,seekContext) " +
					"values " +
					"	(?,?,?,?,?)";
		Object[] values = {seekBook.getSeekName(),seekBook.getSeekAuthor(),seekBook.getSeekPress(),
				seekBook.getSeekEmail(),seekBook.getSeekContext()};
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delete(int id) {
		String sql = "delete from seekBook where seekId = " + id;
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<SeekBook> findAll() {
		String sql = "select seekId,seekName,seekAuthor,seekPress,seekEmail,seekContext from SeekBook";
		List<SeekBook> seekBooks = null;
		
		try {
			seekBooks = template.query(sql, new SeekBookMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seekBooks;
	}
	
}