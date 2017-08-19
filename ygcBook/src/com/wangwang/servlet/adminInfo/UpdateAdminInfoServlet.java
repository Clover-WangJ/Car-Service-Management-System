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
		
		String msg = "ʧ��";
		String returnPath = "/FindByIdServlet?adminId=" + adminId;
		if (adminInfoDAO.update(adminInfo)) {
			msg = "�ɹ�";
			returnPath = "/AdminInfoServlet";
		}
		//��ʾ��Ϣ
		request.setAttribute("msg", "�޸Ĺ���Ա��Ϣ" + msg);
		//����·��
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("background/message.jsp").forward(request, response);
	}
}
