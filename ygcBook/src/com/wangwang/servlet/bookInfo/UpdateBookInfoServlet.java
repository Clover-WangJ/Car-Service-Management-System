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
public class UpdateBookInfoServlet extends HttpServlet {



	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bookName = request.getParameter("bookName");
//		int booktypeId  = Integer.parseInt(request.getParameter("booktypeId"));
		String pbName   = request.getParameter("pbName");
		String author	= request.getParameter("author");
		String context	= request.getParameter("context").trim();
		String smallImg	= request.getParameter("smallImg");
		String bigImg	= request.getParameter("bigImg");
		double price	= Double.parseDouble(request.getParameter("price"));
		String date 	= request.getParameter("pbdate");
		Date	pbdate	= null;
		try {
			pbdate = Conver.ConverToDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
//		double	ygcprice = Double.parseDouble(request.getParameter("ygcprice"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookInfo bookInfo = new BookInfo();
		
		bookInfo.setBookId(bookId);
		bookInfo.setBookName(bookName);
//		bookInfo.setBooktypeId(booktypeId);
		bookInfo.setPbName(pbName);
		bookInfo.setAuthor(author);
		bookInfo.setContext(context);
		bookInfo.setSmallImg(smallImg);
		bookInfo.setBigImg(bigImg);
		bookInfo.setPrice(price);
		bookInfo.setPbdate(pbdate);
		bookInfo.setBookStates(bookStates);
//		bookInfo.setYgcprice(ygcprice);
		BookInfoDAO bookInfoDAO =new BookInfoDAO();
		String msg ="失败";
		String returnPath =  "/FindByIdBookInfoServlet?bookId=" + bookId;
		if (bookInfoDAO.update(bookInfo)) {
			msg = "成功";
			returnPath = "/FindAllBookInfoServlet";
		}
		request.setAttribute("msg", "修改商家信息" + msg);
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
	}

}
