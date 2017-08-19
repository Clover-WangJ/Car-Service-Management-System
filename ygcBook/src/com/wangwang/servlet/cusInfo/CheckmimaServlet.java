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

public class CheckmimaServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String phone = (String) session.getAttribute("bound_mob");
		String bound_pass = request.getParameter("bound_pass").trim();
		String bound_pass2 = request.getParameter("mima2").trim();
		System.out.println(bound_pass+","+bound_pass2);
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		if(bound_pass.length()<=0||bound_pass==null||bound_pass2.compareTo(bound_pass)<0){
			
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
			out.print("<script>");
			out.print("alert('密码修改失败!');");
			out.print("window.location.href='wx/Checkmima.jsp'");
			out.print("</script>");
			out.close();
		}else{
		customInfoDAO.updatemima(phone, bound_pass);
		response.sendRedirect("wx/userinfo.jsp");
		System.out.println("改密成功");
		}
	}

}
