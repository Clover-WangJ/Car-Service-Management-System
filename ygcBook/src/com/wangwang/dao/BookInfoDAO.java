package com.wangwang.dao;


import java.sql.SQLException;
import java.util.List;

import com.wangwang.conver.Conver;

import com.wangwang.db.Template;
import com.wangwang.entity.BookInfo;
import com.wangwang.mapping.BookInfoMapping;

import static com.wangwang.dao.Tool.ENTER;

public class BookInfoDAO {
	
	private Template template = new Template();
	
	public boolean save(BookInfo bookInfo) {
		
		
		String sql = "insert into bookInfo" +
					"		(bookName,booktypeId,pbName,author,context," + ENTER +
					"		smallImg,bigImg,price,pbdate,bookStates,"    + ENTER +
					"		ygcprice)" 									 + ENTER +
					"values	"											 + ENTER +
					" 		(?,?,?,?,?,"  								 + ENTER +
					"		?,?,?,?,?,"  								 + ENTER +
					"		?)";
		String pbdates = Conver.ConverToString(bookInfo.getPbdate());
		
		Object[] values = {bookInfo.getBookName(),bookInfo.getBooktypeId(),bookInfo.getPbName(),bookInfo.getAuthor(),bookInfo.getContext(),
					bookInfo.getSmallImg(),bookInfo.getBigImg(),bookInfo.getPrice(),pbdates,bookInfo.getBookStates(),
					bookInfo.getYgcprice()};
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动未加载");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接得不到");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(BookInfo bookInfo) {

		String sql = "update bookInfo" 		 + ENTER +
					"set" 				 	 + ENTER +
					"	bookName 	= ?,"    + ENTER +
//					"	booktypeId	= ?,"  	 + ENTER +
					"	pbName 		= ?," 	 + ENTER +
					"	author 		= ?,"  	 + ENTER +
					"	context		= ?," 	 + ENTER +
					"	smallImg	= ?," 	 + ENTER +
					"	bigImg		= ?," 	 + ENTER +
					"	price		= ?,"    + ENTER +
					"	pbdate		= ?,"  	 + ENTER +
					"	bookStates	= ?"    + ENTER +
//					"	ygcprice	= ? " 	 + ENTER +							
					"where " 			   	 + ENTER +
					"	bookId	= ?	";											 
					
		String pbdate = Conver.ConverToString(bookInfo.getPbdate());
		
		Object[] values = {bookInfo.getBookName(),bookInfo.getPbName(),bookInfo.getAuthor(),bookInfo.getContext(),
							bookInfo.getSmallImg(),bookInfo.getBigImg(),bookInfo.getPrice(),pbdate,bookInfo.getBookStates(),
							bookInfo.getBookId()};
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动未加载");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接得不到");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateStates(int states,int id ) {
		String sql = "update bookInfo set bookStates = ? where bookId = ?" ;
		try {
			return (template.update(sql,states,id) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
/*	public boolean delete(int id) {
		String sql = "delete from bookInfo where bookId = " + id;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}*/
	
	public List<BookInfo> findAll(int states) {
		String sql = "select "											 + ENTER +
					"		bookId,bookName,booktypeId,pbName,author," 	 + ENTER +
					"		context,smallImg,bigImg,price,pbdate," 		 + ENTER +
					"		bookStates,	ygcprice " 						 + ENTER +
					"from bookInfo"										 + ENTER +
					"		where bookStates";
		StringBuffer sb = new StringBuffer(sql); 
		switch (states) {
		case 5:
			sb.append("<> 4");
		break;
		default:
			sb.append(" = " + states);
		}
		List<BookInfo> bookInfos = null;
		try {
			bookInfos	= template.query(sb.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return bookInfos;
		
	}
	
	/*
	 * @查询其他，
	 * @模糊查询
	 * @分页
	 * String find 为简化代码
	 */
	public Object findCheck(int nowPage, int pageSize, String bookName, String author, String pbName, float initPrice, float endPrice) {
		StringBuffer where = new StringBuffer();
		if (bookName != null){
			where.append(" and bookName like '%" + bookName+ "%' ");
		}
		if(author != null) {
			where.append(" and bookStates = 2 and author like '%" + author + "%' ");
		}
		if (pbName != null ) {
			where.append(" and pbName like '%" + pbName + "%'");
		}
		if (initPrice > 0 && endPrice > 0) {
			where.append(" and ygcprice between " + initPrice + " and " + endPrice );
		}
		if ("".equals(bookName) && "".equals(author) && "".equals(pbName) && initPrice <= 0 && endPrice <= 0) {
			where.append(" and bookId = 0 "  );
		}
		return where;
	}
	
	public List<BookInfo> findOther(int nowPage, int pageSize, String bookName, String author, String pbName, float initPrice, float endPrice ) {

		
		Object where = this.findCheck(nowPage, pageSize, bookName, author, pbName, initPrice, endPrice);
		String sql = "select " +
		" top "	+ pageSize									 + ENTER +
		"		bookId,bookName,booktypeId,pbName,author," 	 + ENTER +
		"		context,smallImg,bigImg,price,pbdate," 		 + ENTER +
		"		bookStates,	ygcprice " 						 + ENTER +
		"from bookInfo where 1=1 and bookStates = 2 " + where 				 + ENTER +
		"and	" 											 + ENTER +
		"	bookId not in" 									 + ENTER +
		"	(select top " + (nowPage -1)*pageSize 			 + ENTER +
		" 	bookId from bookInfo where 1=1 and bookStates = 2 " + where 		 + ENTER +
		"	)";
		List<BookInfo> bookInfos = null;
		try {
			bookInfos	= template.query(sql.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return bookInfos;
		
	}
	
	public int  findOtherPage(int nowPage, int pageSize, String bookName, String author, String pbName, float initPrice, float endPrice) {
		int pageCount = 0;
		Object where = this.findCheck(nowPage, pageSize, bookName, author, pbName, initPrice, endPrice);
		
		String sql = "select "											 + ENTER +
					"		count(*)"								 	 + ENTER +
					"from bookInfo where 1=1 and bookStates = 2"										 + ENTER +
					where;

		try {
			int rowCount = template.query(sql.toString());
			pageCount = rowCount / pageSize;
			if (rowCount % pageSize != 0) {
				pageCount ++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return pageCount;
	}
	public int  findOtherRow(int nowPage, int pageSize, String bookName, String author, String pbName, float initPrice, float endPrice) {
		
		Object where = this.findCheck(nowPage, pageSize, bookName, author, pbName, initPrice, endPrice);
		
		String sql = "select "											 + ENTER +
					"		count(*)"								 	 + ENTER +
					"from bookInfo where 1=1 and bookStates = 2"	 + ENTER +
					where;
		int rowCount = 0;
		try {
			rowCount = template.query(sql.toString());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return rowCount;
	}
	
	/**
	 * 
	 * @舍弃
	 * 翻页
	 * @param nowPage 当前页
	 * @param pageSize 每页条数
	 * @param states	状态
	 * @return
	 */
/*	public List<BookInfo> getPageData(int nowPage, int pageSize, int states) {
		
		StringBuffer where = new StringBuffer(" where bookStates ");
		switch (states) {
		case 5:
			where.append("<> 4");
		break;
		default:
			where.append(" = " + states);
		}
		
		String sql = "select " +
					" top "	+ pageSize									 + ENTER +
					"		bookId,bookName,booktypeId,pbName,author," 	 + ENTER +
					"		context,smallImg,bigImg,price,pbdate," 		 + ENTER +
					"		bookStates,	ygcprice " 						 + ENTER +
					"from bookInfo "	 + where						 + ENTER +
					"and	" 											 + ENTER +
					"	bookId not in" 									 + ENTER +
					"	(select top " + (nowPage -1)*pageSize 			 + ENTER +
					" 	bookId from bookInfo " + where 					 + ENTER +
					"	)";
		
	
		List<BookInfo> bookInfos = null;
		try {
			bookInfos	= template.query(sql.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return bookInfos;
		
	}*/

	/**
	 * 	
	 * 模糊查询
	 *@bookName 书名查询
	 *@author 	作者查询
	 *老代码，舍弃
	 *
	 */
/*public List<BookInfo> findOtherData(int nowPage, int pageSize, String bookName, String author) {

		StringBuffer where = new StringBuffer(" where 1=1 ");
		if (bookName.length() > 0) {
			where.append(" and bookStates = 2 and bookName like '%" + bookName
					+ "%' ");
		} else if (author.length() > 0) {
			where.append(" and bookStates = 2 and author like '%" + author + "%' ");
		}
			
		String sql = "select " +
					" top "	+ pageSize									 + ENTER +
					"		bookId,bookName,booktypeId,pbName,author," 	 + ENTER +
					"		context,smallImg,bigImg,price,pbdate," 		 + ENTER +
					"		bookStates,	ygcprice " 						 + ENTER +
					"from bookInfo "	 + where 				 + ENTER +
					"and	" 											 + ENTER +
					"	bookId not in" 									 + ENTER +
					"	(select top " + (nowPage -1)*pageSize 			 + ENTER +
					" 	bookId from bookInfo " + where 		 + ENTER +
					"	)";
		
	
		List<BookInfo> bookInfos = null;
		try {
			bookInfos	= template.query(sql.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return bookInfos;
		
	}*/




	
public List<BookInfo> getPageData(int nowPage, int pageSize, int states, int type) {
		
		StringBuffer where = new StringBuffer(" where bookStates ");
		switch (states) {
		case 5:
			where.append("<> 4");
		break;
		default:
			where.append(" = " + states);
		}
		StringBuffer types = new StringBuffer(" and  booktypeId ");
		if (type == 0){
			types.append("<> 0");
		}else {
			types.append(" = " + type);
		}
		
		String sql = "select " +
					" top "	+ pageSize									 + ENTER +
					"		bookId,bookName,booktypeId,pbName,author," 	 + ENTER +
					"		context,smallImg,bigImg,price,pbdate," 		 + ENTER +
					"		bookStates,	ygcprice " 						 + ENTER +
					"from bookInfo "	 + where + types				 + ENTER +
					"and	" 											 + ENTER +
					"	bookId not in" 									 + ENTER +
					"	(select top " + (nowPage -1)*pageSize 			 + ENTER +
					" 	bookId from bookInfo " + where 	+ types			 + ENTER +
					"	)";
		
	
		List<BookInfo> bookInfos = null;
		try {
			bookInfos	= template.query(sql.toString(), new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return bookInfos;
		
	}

	public int  getPageCount(int pageSize, int states, int type) {
		int pageCount = 0;
		StringBuffer where = new StringBuffer(" where bookStates ");
		switch (states) {
		case 5:
			where.append("<> 4");
		break;
		default:
			where.append(" = " + states);
		}
		StringBuffer types = new StringBuffer(" and  booktypeId ");
		if (type == 0){
			types.append("<> 0");
		}else {
			types.append(" = " + type);
		}
		String sql = "select "											 + ENTER +
					"		count(*)"								 	 + ENTER +
					"from bookInfo"										 + ENTER +
					where + types;
	
	
		try {
			int rowCount = template.query(sql.toString());
			pageCount = rowCount / pageSize;
			if (rowCount % pageSize != 0) {
				pageCount ++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return pageCount;
	}
	public int  getRowCount(int states, int type) {
		
		StringBuffer where = new StringBuffer(" where bookStates ");
		switch (states) {
		case 5:
			where.append("<> 4");
		break;
		default:
			where.append(" = " + states);
		}
		StringBuffer types = new StringBuffer(" and  booktypeId ");
		if (type == 0){
			types.append("<> 0");
		}else {
			types.append(" = " + type);
		}
		String sql = "select "											 + ENTER +
					"		count(*)"								 	 + ENTER +
					"from bookInfo"										 + ENTER +
					where + types;
	
		int rowCount = 0;
		try {
			rowCount = template.query(sql.toString());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return rowCount;
		
	}
	
	public BookInfo findById(int id) {
		String sql = "select "								 + ENTER +
		"		bookId,bookName,booktypeId,pbName,author," 	 + ENTER +
		"		context,smallImg,bigImg,price,pbdate," 		 + ENTER +
		"		bookStates,	ygcprice " 						 + ENTER +
		"from bookInfo" 									 + ENTER +
		"		where bookId = " + id;
		List<BookInfo> bookInfos = null;
		try {
			bookInfos	= template.query(sql, new BookInfoMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfos.get(0);
	}
	//测试
	
	
}
