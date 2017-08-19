package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.CustomInfo;

public class CheckshoujiServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String phone = (String) session.getAttribute("bound_mob");
		String shouji = request.getParameter("shouji");
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		boolean addshouji = customInfoDAO.updateshouji(phone,shouji);
		System.out.println(phone+","+shouji);
		if(addshouji){
		response.sendRedirect("wx/userinfo.jsp");
		session.setAttribute("bound_mob", shouji);
		System.out.println("手机成功");
		}else{
			System.out.println("手机修改失败");
			response.sendRedirect("wx/addchepai.jsp");
		}
	}

}
