package com.wangwang.servlet.bookType;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.wangwang.dao.BookTypeDAO;

import com.wangwang.entity.BookType;

@SuppressWarnings("serial")
public class FindByIdBookTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		BookTypeDAO BookTypeDAO = new BookTypeDAO();
		BookType bookType = BookTypeDAO.findById(bookTypeId);
		
		request.setAttribute("bookType", bookType);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/bookTypeJsp/updateBookType.jsp");
		rd.forward(request, response);
	}

}
