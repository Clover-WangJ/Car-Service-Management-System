package com.wangwang.servlet.bookInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;
import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookInfo;
import com.wangwang.entity.BookType;

@SuppressWarnings("serial")
public class FindByIdBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		
		BookInfoDAO bookInfoDAO = new BookInfoDAO();
		BookInfo bookInfo = bookInfoDAO.findById(bookId);
		
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		List<BookType> bookTypes = bookTypeDAO.findAll();
	
	
		request.setAttribute("bookTypes", bookTypes);
	
		request.setAttribute("bookInfo", bookInfo);
		
		request.getRequestDispatcher("/bookInfoJsp/updateBookInfo.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
