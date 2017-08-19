package com.wangwang.servlet.bookInfo;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.conver.Conver;
import com.wangwang.dao.BookInfoDAO;
import com.wangwang.entity.BookInfo;

@SuppressWarnings("serial")
public class SaveBookInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String bookName =request.getParameter("bookName");
		int booktypeId = Integer.parseInt(request.getParameter("booktypeId"));
		String pbName   = request.getParameter("pbName");
		String author	= request.getParameter("author");
		String context	= request.getParameter("context");
		String smallImg	= request.getParameter("smallImg");
		String bigImg	= request.getParameter("bigImg");
		double price	= Double.parseDouble(request.getParameter("price"));
		
		Date	pbdate	= null;
		try {
			pbdate = Conver.ConverToDate(request.getParameter("pbdate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
		double	ygcprice = Double.parseDouble("0");

		BookInfo bookInfo = new BookInfo(bookName, booktypeId, pbName, author,context.trim(), 
										smallImg, bigImg, price, pbdate, bookStates,
										ygcprice);
		BookInfoDAO bookInfoDAO =new BookInfoDAO();
		
		String msg = "ʧ��";
		String returnPath = "/bookInfoJsp/saveBookInfo.jsp";
		if (bookInfoDAO.save(bookInfo)) {
			msg = "�ɹ�";
			returnPath = "/FindAllBookInfoServlet";
		}
		//��ʾ��Ϣ
		request.setAttribute("msg", "����ͼ����Ϣ" + msg);
		//����·��
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
	}

}
