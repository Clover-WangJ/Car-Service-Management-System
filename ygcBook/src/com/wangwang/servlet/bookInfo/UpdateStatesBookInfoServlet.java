package com.wangwang.servlet.bookInfo;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;


@SuppressWarnings("serial")
public class UpdateStatesBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookInfoDAO bookInfoDAO = new BookInfoDAO();
		String msg = "ʧ��";
		
		if (bookInfoDAO.updateStates(3,bookId)) {
			msg = "�ɹ�";
		}
		request.setAttribute("msg", "ͼ����Ϣɾ��(������)" + msg);
		//����
		request.setAttribute("returnPath", "/FindAllBookInfoServlet");
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
		
	}

}
