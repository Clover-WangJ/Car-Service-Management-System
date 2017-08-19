package com.wangwang.dao;


import static com.wangwang.dao.Tool.ENTER;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.Template;
import com.wangwang.entity.BookInfo;
import com.wangwang.entity.BookType;
import com.wangwang.mapping.BookInfoMapping;
import com.wangwang.mapping.BookTypeMapping;

public class BookTypeDAO {
	
	private Template template = new Template();
	public boolean save(BookType bookType) {
		 
		String sql = "insert into bookType " 							+ ENTER +
					"		(isDelete,parentId,bookTypeName,context) "  + ENTER +
					"values" 											+ ENTER +
					"		(?,?,?,?)";
		
		Object[] values = {bookType.getIsDelete(),bookType.getParentId(),bookType.getBookTypeName(),bookType.getContext()};
		
		
		try {
			return (template.update(sql, values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(BookType bookType) {

		String sql = "update bookType " 								+ ENTER +
					"set" 												+ ENTER +
					"		isDelete 	 = ?," 							+ ENTER +
					"		parentId 	 = ?," 							+ ENTER +
					"		bookTypeName = ?,"						    + ENTER +
					"		context      = ?" 							+ ENTER +
					"where	" 											+ ENTER +
					"	bookTypeId = ?";
		
		Object[] values = {bookType.getIsDelete(),bookType.getParentId(),bookType.getBookTypeName(),bookType.getContext(),bookType.getBookTypeId()};
		try {
			return (template.update(sql,values) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	public boolean isDelete(int id) {
		String sql = "update bookType set isDelete = 2 where bookTypeId =" + id;
		
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean  delete(int id) {
		String sql = "delete from bookType where bookTypeId =" + id;
		try {
			return (template.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	
	
	public List<BookType> findAll() {
		String sql = "select bookTypeId,isDelete,parentId,bookTypeName,context from bookType";
		List<BookType> bookTypes = null;
		
		try {
			bookTypes = template.query(sql, new BookTypeMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookTypes;
	}
	
	public List<BookType> findType(int parentId) {
		
		
		String sql = "select  bookTypeId,isDelete,parentId,bookTypeName,context from bookType" +
				"	where parentId = " + parentId;
		List<BookType> bookTypes = null;
		
		try {
			bookTypes = template.query(sql, new BookTypeMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookTypes;
	}
	

	public BookType findById(int id) {
		String sql = "select bookTypeId,isDelete,parentId,bookTypeName,context from bookType where bookTypeId = " + id;
		List<BookType> bookTypes = null;
	
		try {
			bookTypes = template.query(sql, new BookTypeMapping());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookTypes.get(0);
	}
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
}
