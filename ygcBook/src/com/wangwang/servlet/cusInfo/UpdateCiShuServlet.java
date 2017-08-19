package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.AdminInfoDAO;
import com.wangwang.dao.CusInfoDAO;
import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.AdminInfo;
import com.wangwang.entity.CusInfo;
import com.wangwang.entity.CustomInfo;
import com.wangwang.entity.Telmsg;
@SuppressWarnings("serial")
public class UpdateCiShuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tel = request.getParameter("phone").trim();
		String bound_pass = request.getParameter("bound_pass").trim();
		System.out.println(tel+","+bound_pass);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String times = formatter.format(new Date());
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		boolean jihui = customInfoDAO.update(tel,times);

		if (jihui) {		
			CustomInfo customInfo = customInfoDAO.findNameAndPwd(tel, bound_pass);
	
			int cishu =customInfo.getJf();

			HttpSession session = request.getSession();
			session.setAttribute("cishu", cishu);
			response.sendRedirect("wx/userinfo.jsp");
	
		}else{
			
		}
		
	}

}
