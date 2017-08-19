package com.wangwang.servlet.customerInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class InvaildateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String opType = request.getParameter("opType");
		
		if ("exit".equals(opType)) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("InitIndexServlet");
		}
	}

}
