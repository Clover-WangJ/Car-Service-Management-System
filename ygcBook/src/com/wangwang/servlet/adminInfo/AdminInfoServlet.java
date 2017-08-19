package com.wangwang.servlet.adminInfo;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.entity.AdminInfo;

public class AdminInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("gbk");
		
		
		AdminInfoDAO adminInfoDAO = new AdminInfoDAO();
		List<AdminInfo> adminInfos = adminInfoDAO.findAll();
		
		request.setAttribute("adminInfos", adminInfos);
		request.getRequestDispatcher("/adminInfoJsp/adminInfo.jsp").forward(request, response);
		
	}

}
