package com.wangwang.servlet.customInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CusInfoDAO;
import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.CusInfo;
import com.wangwang.entity.CustomInfo;

public class CheckCustomInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("tel2").trim();
		String userPass = request.getParameter("pwd2").trim();
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		CustomInfo customInfo = customInfoDAO.findNameAndPwd(phone, userPass);
		if (customInfo == null) {
			request.setAttribute("ss", "ss");

			request.getRequestDispatcher("login.jsp")
					.forward(request, response);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("cusInfo", customInfo);
			session.setAttribute("tel2", phone);
			session.setAttribute("userPass", userPass);
			List<String> ssss = customInfoDAO.findWXxiaofei(phone);
			System.out.println(ssss.toString());
			session.setAttribute("ssss", ssss.toString());
			String c =  customInfoDAO.findNameAndPwd(phone, userPass).getName();
			String a =  customInfoDAO.findNameAndPwd(phone, userPass).getAddress();
			String b =  customInfoDAO.findNameAndPwd(phone, userPass).getCarNo();
			if(c==null){
				c="无姓名";
			}if(a ==null){
				a="无地址";
			}if(b==null){
				b="暂无车辆";
			}
			
			session.setAttribute("dizhi",a);
			session.setAttribute("chepai",b);
			session.setAttribute("name", c);
			response.sendRedirect("main.jsp");
		}

	}

}
