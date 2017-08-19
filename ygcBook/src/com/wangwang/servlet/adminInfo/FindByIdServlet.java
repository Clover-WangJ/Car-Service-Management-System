package com.wangwang.servlet.adminInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.entity.AdminInfo;

public class FindByIdServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("adminId").trim());
		AdminInfoDAO adminInfoDAO = new AdminInfoDAO();
		AdminInfo adminInfo = adminInfoDAO.findById(id);
		
		request.setAttribute("adminInfo", adminInfo);
		request.getRequestDispatcher("adminInfoJsp/updateAdmin.jsp").forward(request, response);
	}

}
