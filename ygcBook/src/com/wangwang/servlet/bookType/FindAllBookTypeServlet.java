package com.wangwang.servlet.bookType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;

@SuppressWarnings("serial")
public class FindAllBookTypeServlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		List<BookType> bookTypes = bookTypeDAO.findAll();
		
		request.setAttribute("bookTypes", bookTypes);
		RequestDispatcher rd = request.getRequestDispatcher("/bookTypeJsp/bookTypeList.jsp");
		rd.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


}
