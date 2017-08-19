package com.wangwang.servlet.customInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.CustomInfo;
import com.wangwang.entity.Pinglun;

public class AddWXPLServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8"); 
		String shopid = request.getParameter("id").trim();	
		System.out.println("…Ãº“id:"+shopid);
		String phone = (String) session.getAttribute("bound_mob");
		String advise = new String(request.getParameter("advise").trim().getBytes("iso-8859-1"),"utf-8");
		String level = "5";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String time = formatter.format(new Date());
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		Pinglun pinglun = new Pinglun(phone, advise,level,time,shopid);
		boolean addPL = customInfoDAO.updatePL(pinglun);
//		System.out.println(phone+","+advise+","+level);
		if(addPL){
			
			List<String> str2 = customInfoDAO.findadvise(shopid);
			System.out.println("str2"+str2);
			session.setAttribute("advises", str2);	
		}else{
			System.out.println("ÃÌº” ß∞‹");
			response.sendRedirect("wx/pinglun.jsp");
		}
	}

}
