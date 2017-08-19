package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.BookStock;
import com.wangwang.mapping.BookStockMapping;

public class BookStockDAO {

	private Template template = new Template();
	
	public boolean save(BookStock bookStock) {
		
		String sql = "insert into bookStock" +
					"	(bookId,bookCount,selledCount,minNum) " +
					"values" +
					"	?,?,?";
		try {
			return (template.update(sql, bookStock.getBookId(),bookStock.getBookCount(),
					bookStock.getSelledCount(),bookStock.getMinNum()) == 1) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean update(BookStock bookStock) {
		
		String sql = "update bookStock" +
					"set" +
					"	bookId= ?," +
					"	bookCount = ?," +
					"	selledCount = ?," +
					"	minNum = ? " +
					"where stockId = ?";
				
		try {
			return (template.update(sql, bookStock.getBookId(),bookStock.getBookCount(),
							bookStock.getSelledCount(),bookStock.getMinNum(),
							bookStock.getStockId()) == 1) ;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(int id) {
		
		String sql = "delete from bookStock where stockId = " + id;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<BookStock> findAll() {
		String sql = "select " +
					"	stockId,bookId,bookCount,selledCount,minNum" +
					"from bookStock";
		
	
		 List<BookStock>  bookStocks = null;
		 
		 try {
			bookStocks = template.query(sql, new BookStockMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookStocks;
	}
	
	public BookStock findById(int id) {
		String sql = "select " +
					"	stockId,bookId,bookCount,selledCount,minNum" +
					"from bookStock" +
					"where stockId = " + id;
		
	
		 List<BookStock>  bookStocks = null;
		 
		 try {
			bookStocks = template.query(sql, new BookStockMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookStocks.get(0);
	}
}
