package com.wangwang.servlet.bookType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;

@SuppressWarnings("serial")
public class SaveBookTypeServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		request.setCharacterEncoding("gbk");
		int isDelete = Integer.parseInt(request.getParameter("isDelete"));
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String bookTypeName = request.getParameter("bookTypeName");
		String context		= request.getParameter("context").trim();
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType bookType = new BookType(isDelete,parentId,bookTypeName,context);
		
		String msg = "失败";
		String returnPath = "/bookTypeJsp/saveBookType.jsp";
		if (bookTypeDAO.save(bookType)) {
			msg = "成功";
			
		}
		//提示消息
		request.setAttribute("msg", "新增图书信息" + msg);
		//返回路径
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
	}

}
