package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.dao.CusInfoDAO;
import com.wangwang.entity.AdminInfo;
import com.wangwang.entity.CusInfo;
@SuppressWarnings("serial")
public class SaveCusIFServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tel = request.getParameter("tel").trim();
		String customerName = request.getParameter("uname").trim();
		String pwd = request.getParameter("pwd").trim();
		CusInfoDAO cusInfoDAO = new CusInfoDAO();
		CusInfo cusInfo = new CusInfo(tel,customerName, pwd);
		
		String msg = "ʧ��";
		String returnPath = null;
		if (cusInfoDAO.save(cusInfo)) {
			msg = "�ɹ�";
		}
		// ��ʾ��Ϣ
		request.setAttribute("msg", "�����׼�ע�����" + msg);
		// ����·��
		request.setAttribute("returnPath", returnPath);
		request.getRequestDispatcher("yanZCServlet").forward(request,
				response);
	}

}
