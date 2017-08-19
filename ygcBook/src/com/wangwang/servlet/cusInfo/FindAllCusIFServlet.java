package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.CusInfoDAO;
import com.wangwang.dao.CustomerInfoDAO;
import com.wangwang.entity.CusInfo;

public class FindAllCusIFServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CusInfoDAO cusInfoDAO = new CusInfoDAO();
		List<CusInfo> CusInfos = cusInfoDAO.findAll();

		request.setAttribute("CusInfos", CusInfos);
		request.getRequestDispatcher("cusInfoJsp/cusList.jsp").forward(request,
				response);

	}

}
