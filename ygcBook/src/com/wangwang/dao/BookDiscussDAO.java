package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.BookDiscuss;
import com.wangwang.mapping.BookDiscussMapping;

public class BookDiscussDAO {

	private Template template  = new Template();
	
	public boolean save(BookDiscuss bookDiscuss) {
		String sql = "insert into bookDiscuss" +
					"	(bookId,customerId,context,states)" +
					"values" +
					"	?,?,?,?";
		Object[] values = {bookDiscuss.getBookId(),bookDiscuss.getCustomerId(),
						bookDiscuss.getContext(),bookDiscuss.getStates()};
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(BookDiscuss bookDiscuss) {
		String sql = "update bookDiscuss" +
					"set" +
					"	(bookId = ?," +
					"	customerId = ?," +
					"	context = ?," +
					"	states =?)" +
					"where disId = ?";
		Object[] values = {bookDiscuss.getBookId(),bookDiscuss.getCustomerId(),
						bookDiscuss.getContext(),bookDiscuss.getStates()};
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateStates(int states,int id) {
		String sql = "update bookDiscuss set states = ? where disId = ? ";
		try {
			return (template.update(sql, states,id) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
/*	public List<BookDiscuss> findAll() {
		String sql = "select " +
					"	disId,bookId,customerId,states,context  " +
					"from BookDiscuss";
		List<BookDiscuss> bookDiscusies = null;
		try {
			bookDiscusies = template.query(sql, new BookDiscussMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookDiscusies;
	}*/
	
	public List<BookDiscuss> findAll(int bookId) {
		
		String sql = "select " +
					"	disId,bookId,customerId,states,context " +
					"	from BookDiscuss" +
					" 	where states = 1 and bookId = " + bookId;
		List<BookDiscuss> bookDiscusies = null;
		try {
			bookDiscusies = template.query(sql, new BookDiscussMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookDiscusies;
	}
	
	public BookDiscuss findDis(int disId) {
		
		String sql = "select " +
					"	disId,bookId,customerId,states,context  " +
					"	from BookDiscuss" +
					" 	where disId = " + disId;
		List<BookDiscuss> bookDiscusies = null;
		try {
			bookDiscusies = template.query(sql, new BookDiscussMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookDiscusies.get(0);
	}
	
/*	public BookDiscuss findById(int id) {
		String sql = "select " +
					"	disId,bookId,customerId,states,context " +
					"from BookDiscuss" +
					"where	disId = " + id;
		List<BookDiscuss> bookDiscusies = null;
		try {
			bookDiscusies = template.query(sql, new BookDiscussMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookDiscusies.get(0);
	}*/
}
