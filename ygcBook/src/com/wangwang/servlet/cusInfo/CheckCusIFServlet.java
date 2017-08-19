package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.dao.CusInfoDAO;
import com.wangwang.entity.AdminInfo;
import com.wangwang.entity.CusInfo;

@SuppressWarnings("serial")
public class CheckCusIFServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String tel2 = request.getParameter("tel2").trim();
		String pwd2  = request.getParameter("pwd2").trim();
		CusInfoDAO cusInfoDAO = new CusInfoDAO();
		CusInfo cusInfo = cusInfoDAO.findNameAndPwd(tel2, pwd2);
		if (cusInfo == null){
			request.setAttribute("ss", "ss");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}else  {
			HttpSession session = request.getSession();
			session.setAttribute("cusInfo", cusInfo);
			session.setAttribute("tel2", tel2);
			response.sendRedirect("main.jsp");
		}
		
	}
}
