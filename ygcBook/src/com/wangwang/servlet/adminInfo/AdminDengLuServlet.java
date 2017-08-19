package com.wangwang.servlet.adminInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.entity.AdminInfo;

@SuppressWarnings("serial")
public class AdminDengLuServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String name = request.getParameter("name").trim();
		String pwd  = request.getParameter("pwd").trim();
		
		AdminInfoDAO adminInfoDAO = new AdminInfoDAO();
		AdminInfo adminInfo = adminInfoDAO.findNameAndPwd(name, pwd);
		
		if (adminInfo == null) {
			request.getRequestDispatcher("adminInfoJsp/adminDenglu.jsp").forward(request, response);
			
		}else  {
			HttpSession session = request.getSession();
			session.setAttribute("adminInfo", adminInfo);
			response.sendRedirect(request.getContextPath() +"/background/index.jsp");
		}
		
	}
}
