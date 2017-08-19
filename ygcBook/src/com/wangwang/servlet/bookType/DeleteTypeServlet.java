package com.wangwang.servlet.bookType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookTypeDAO;

public class DeleteTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		BookTypeDAO BookTypeDAO = new BookTypeDAO();
		
		String msg = "ʧ��";
		
		if (BookTypeDAO.delete(bookTypeId)) {
			msg = "�ɹ�";
		}
		request.setAttribute("msg", "ͼ�����ɾ��" + msg);
		//����
		request.setAttribute("returnPath", "/FindAllBookTypeServlet");
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

}
