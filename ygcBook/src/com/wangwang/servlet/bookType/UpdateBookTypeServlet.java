package com.wangwang.servlet.bookType;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;

@SuppressWarnings("serial")
public class UpdateBookTypeServlet extends HttpServlet {


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		request.setCharacterEncoding("gbk");
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		int isDelete = Integer.parseInt(request.getParameter("isDelete"));
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String bookTypeName = request.getParameter("bookTypeName");
		String context		= request.getParameter("context").trim();
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType bookType = new BookType(bookTypeId,isDelete,parentId,bookTypeName,context);
		
		String msg = "ʧ��";
		String returnPath =  "/FindByIdBookTypeServlet?bookTypeId=" + bookTypeId;
		if (bookTypeDAO.update(bookType)) {
			msg = "�ɹ�";
			returnPath = "/FindAllBookTypeServlet" ;
		}
		//��ʾ��Ϣ
		request.setAttribute("msg", "�޸�ͼ����Ϣ" + msg);
		//����·��
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
	
	
	}
	

}
