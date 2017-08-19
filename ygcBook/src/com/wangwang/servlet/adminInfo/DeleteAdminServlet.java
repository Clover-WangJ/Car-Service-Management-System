package com.wangwang.servlet.adminInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.AdminInfoDAO;

@SuppressWarnings("serial")
public class DeleteAdminServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("adminId"));
		AdminInfoDAO adminInfoDAO = new AdminInfoDAO();
		String msg = "失败";
		String returnPath = "/AdminInfoServlet";
		if (adminInfoDAO.delete(id)) {
			msg = "成功";
		}
		//提示消息
		request.setAttribute("msg", "删除管理员信息" + msg);
		//返回路径
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("background/message.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		this.doGet(request, response);
	}

}
