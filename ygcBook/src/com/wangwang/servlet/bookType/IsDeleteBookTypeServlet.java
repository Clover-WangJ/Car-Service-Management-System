package com.wangwang.servlet.bookType;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;
import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;

public class IsDeleteBookTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		BookTypeDAO BookTypeDAO = new BookTypeDAO();
		
		String msg = "失败";
		
		if (BookTypeDAO.isDelete(bookTypeId)) {
			msg = "成功";
		}
		request.setAttribute("msg", "图书类别不可用" + msg);
		//返回
		request.setAttribute("returnPath", "/FindAllBookTypeServlet");
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		BookTypeDAO BookTypeDAO = new BookTypeDAO();
		
		String msg = "失败";
		
		if (BookTypeDAO.isDelete(bookTypeId)) {
			msg = "成功";
		}
		System.out.println(BookTypeDAO.isDelete(bookTypeId));
		request.setAttribute("msg", "图书类别不可用" + msg);
		//返回
		request.setAttribute("returnPath", "/FindAllBookTypeServlet");
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
	}

}
