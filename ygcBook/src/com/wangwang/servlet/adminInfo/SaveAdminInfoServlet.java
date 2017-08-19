package com.wangwang.servlet.adminInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.entity.AdminInfo;

@SuppressWarnings("serial")
public class SaveAdminInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String pwd  = request.getParameter("pwd").trim();
		int    type = Integer.parseInt(request.getParameter("type").trim());
		
		AdminInfoDAO adminInfoDAO = new AdminInfoDAO();
		AdminInfo adminInfo = new AdminInfo(name, pwd, type);
		
		String msg = "失败";
		String returnPath = "/adminInfoJsp/saveAdmin.jsp";
		if (adminInfoDAO.save(adminInfo)) {
			msg = "成功";
			returnPath = "/AdminInfoServlet";
		}
		//提示消息
		request.setAttribute("msg", "新增管理员信息" + msg);
		//返回路径
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("background/message.jsp").forward(request, response);
	}

}
