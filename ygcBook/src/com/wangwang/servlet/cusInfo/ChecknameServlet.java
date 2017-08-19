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

public class ChecknameServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String phone = (String) session.getAttribute("bound_mob");
		String name = request.getParameter("name");
		if(name.trim().length()<=0||name==null){
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
			out.print("<script>");
			out.print("alert('姓名不能为空!');");
			out.print("window.location.href='wx/addname.jsp'");
			out.print("</script>");
			out.close();
			
		}else{
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		boolean addchepai = customInfoDAO.updatename(phone, name);
		System.out.println(phone+","+name);
		if(addchepai){
		response.sendRedirect("wx/userinfo.jsp");
		session.setAttribute("name", name);
		System.out.println("姓名成功");
		}
		}
	}

}
