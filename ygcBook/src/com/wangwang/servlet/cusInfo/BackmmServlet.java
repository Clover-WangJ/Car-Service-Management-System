package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CustomInfoDAO;

public class BackmmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("gbk");
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=gbk");
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
			String phone2 = new String(request.getParameter("textfield").trim().getBytes("iso-8859-1"),"gbk");
			String mima = new String(request.getParameter("textfield22").trim().getBytes("iso-8859-1"),"gbk");
			String mima2 = new String(request.getParameter("textfield222").trim().getBytes("iso-8859-1"),"gbk");
			int yzm = 0;
			if(request.getParameter("textfield2").trim().length()>0){
			yzm = Integer.parseInt(request.getParameter("textfield2").trim());
			}			
			int num = (Integer)session.getAttribute("num");
			System.out.println(mima+","+mima2);
			if(mima2.compareTo(mima)!=0||mima==null||mima.length()<=0){
				response.setContentType("text/html;charset=GBK");
				PrintWriter out = response.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
				out.print("<script>");
				out.print("alert('ÃÜÂëĞŞ¸ÄÊ§°Ü!');");
				out.print("window.location.href='check.jsp'");
				out.print("</script>");
				out.close();
			}else{
				if(num==yzm && mima2.compareTo(mima)==0 && customInfoDAO.updatemima(phone2, mima)){
					response.setContentType("text/html;charset=GBK");
					PrintWriter out = response.getWriter();
					out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
					out.print("<script>");
					out.print("alert('ÃÜÂëĞŞ¸Ä³É¹¦!');");
					out.print("window.location.href='wx/userinfo.jsp'");
					out.print("</script>");
					out.close();
				}
				
				}
		

	}

}
