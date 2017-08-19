package com.wangwang.servlet.bookInfo;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;
import com.wangwang.dao.BookTypeDAO;

import com.wangwang.entity.BookInfo;
import com.wangwang.entity.BookType;


@SuppressWarnings("serial")
public class FindAllBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageCount = 0;
		int pageSize  = 6;
		int nowPage   = 1;
		int typeId    = 0;
		int rowCount  = 0;
		List<BookInfo> bookInfos = null;
		BookInfoDAO bookInfoDAO = new BookInfoDAO();
		String strStates = request.getParameter("states");
		if (strStates == null) {//显示所有图书
			strStates = "5";
		}
		int states = Integer.parseInt(strStates);

		
		String strNowPage = request.getParameter("nowPage");
		if (strNowPage == null) {
			strNowPage = "1";
		}
		String strPageSize = request.getParameter("pageSize");
		if (strPageSize == null) {
			strPageSize = "5";
		}
		
		String strTypeId = request.getParameter("typeId");
		if (strTypeId == null) {
			strTypeId = "0";
		}
		 typeId = Integer.parseInt(strTypeId);
		pageSize =Integer.parseInt(strPageSize);
		
		nowPage = Integer.parseInt(strNowPage);
		pageCount = bookInfoDAO.getPageCount(pageSize, states,typeId);
		rowCount  = bookInfoDAO.getRowCount(states, typeId);
		
		bookInfos = bookInfoDAO.getPageData(nowPage, pageSize, states,typeId);
		
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		List<BookType> bookTypes = bookTypeDAO.findAll();
		
		request.setAttribute("bookTypes", bookTypes);
/*		BookType bookType = new BookType();
		request.setAttribute("bookType", bookType);*/
//	 bookInfos = bookInfoDAO.findAll(states);
		
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("bookInfos", bookInfos);
		request.setAttribute("pageCount", pageCount);
		
		request.setAttribute("states", states);
		request.setAttribute("typeId", typeId);
		RequestDispatcher rd = request.getRequestDispatcher("bookInfoJsp/bookInfoList.jsp");
		rd.forward(request, response);
	}

}
