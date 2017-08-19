package com.wangwang.servlet.customInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.CustomInfo;

public class CheckCustomWXInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("tel").trim();
		String userPass = request.getParameter("pwd").trim();
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		CustomInfo customInfo = customInfoDAO.findNameAndPwd(phone, userPass);
		if (customInfo == null) {
//			request.setAttribute("ss", "ss");

//			request.getRequestDispatcher("reg.html")
//					.forward(request, response);

		} else {
			request.getRequestDispatcher("wx/userinfo.html")
			.forward(request, response);
		}

	}

}
