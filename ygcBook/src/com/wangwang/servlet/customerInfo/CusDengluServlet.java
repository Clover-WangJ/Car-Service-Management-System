package com.wangwang.servlet.customerInfo;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CustomerInfoDAO;
import com.wangwang.entity.CustomerInfo;

@SuppressWarnings("serial")
public class CusDengluServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName").trim();
		String pwd      =  request.getParameter("pwd");
		CustomerInfoDAO customerInfoDAO = new CustomerInfoDAO() ;
		CustomerInfo customerInfo = customerInfoDAO.getNameAndPwd(userName, pwd);
		String msg = "失败";
		String returnPath ="denglu.jsp";
		if (customerInfo != null) {
				//提示消息	
				msg = "成功";
				//测试 返回首页
				returnPath = "/InitIndexServlet";
		}
			HttpSession session = request.getSession();
			session.setAttribute("customerInfo", customerInfo);
			request.setAttribute("msg", "登陆" + msg);
			request.setAttribute("returnPath",returnPath);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	

}
