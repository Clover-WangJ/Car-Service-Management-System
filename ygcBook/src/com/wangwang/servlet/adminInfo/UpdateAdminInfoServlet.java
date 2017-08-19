package com.wangwang.servlet.adminInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.entity.AdminInfo;

@SuppressWarnings("serial")
public class UpdateAdminInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int    adminId = Integer.parseInt(request.getParameter("adminId").trim());
		String name = request.getParameter("name").trim();
		String pwd  = request.getParameter("pwd").trim();
		int    type = Integer.parseInt(request.getParameter("type").trim());
		
		AdminInfoDAO adminInfoDAO = new AdminInfoDAO();
		AdminInfo adminInfo = new AdminInfo(adminId,name, pwd,type);
		
		String msg = "失败";
		String returnPath = "/FindByIdServlet?adminId=" + adminId;
		if (adminInfoDAO.update(adminInfo)) {
			msg = "成功";
			returnPath = "/AdminInfoServlet";
		}
		//提示消息
		request.setAttribute("msg", "修改管理员信息" + msg);
		//返回路径
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("background/message.jsp").forward(request, response);
	}
}
