package com.wangwang.servlet.customInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CusInfoDAO;
import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.CusInfo;
import com.wangwang.entity.CustomInfo;

public class SaveCustomInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("tel").trim();
		String name = request.getParameter("uname").trim();
		String userPass = request.getParameter("pwd").trim();
		String carType = request.getParameter("leixing").trim();
		String carNo = request.getParameter("carNo").trim();
		System.out.println(phone+","+name+","+userPass+","+carType+","+carNo);
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		CustomInfo customInfo = new CustomInfo(phone,userPass,name,carNo,carType);
		CustomInfo customInfoP = customInfoDAO.findPwd(phone);
        
		
		String returnPath = null;
		if (customInfoP != null) {
			request.setAttribute("customInfoP", customInfoP);
			response.setContentType("text/html;charset=GBK");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");   
			out.print("<script>");
			out.print("alert('手机号已注册，请重新输入!');");
			out.print("window.location.href='regist.jsp'");
			out.print("</script>");
			out.close();
		} else {
			customInfoDAO.save(customInfo);
			request.setAttribute("customInfoP", customInfoP);
			response.setContentType("text/html;charset=GBK");
			PrintWriter  out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");   
			out.print("<script>");
			out.print("alert('注册成功!（注：您的资料可同时用于微信及手机客户端的登陆）');");
			out.print("window.location.href='login.jsp'");
			out.print("</script>");
			out.close();
			// 返回路径
//			request.setAttribute("returnPath", returnPath);
//			request.getRequestDispatcher("yanZCServlet").forward(request, response);
		}

		
	}

}
