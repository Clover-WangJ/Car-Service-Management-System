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

public class InfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String phone = (String) session.getAttribute("bound_mob");
		String dizhi = request.getParameter("dz");
		String chepai = request.getParameter("cp");
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		boolean addinfo = customInfoDAO.updateinfo(phone, dizhi,chepai);
		System.out.println(phone+","+dizhi+","+chepai);
		if(addinfo){
			session.setAttribute("addchepai", chepai);
			session.setAttribute("dizhi", dizhi);
		response.sendRedirect("wx/userinfo.jsp");
		
		System.out.println("info添加成功");
		}else{
			System.out.println("info添加失败");
			response.sendRedirect("wx/userinfo.jsp");
		}
	}

}
