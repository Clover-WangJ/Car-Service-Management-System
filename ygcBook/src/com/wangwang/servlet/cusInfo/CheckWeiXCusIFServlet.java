package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.dao.CustomerInfoDAO;
import com.wangwang.entity.CheXianInfo;
import com.wangwang.entity.CustomInfo;
import com.wangwang.entity.Telmsg;
import com.wangwang.entity.WXxiaofeiInfo;

public class CheckWeiXCusIFServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phone = request.getParameter("bound_mob").trim();
		String userPass = request.getParameter("bound_pass").trim();
		
		 
		int status = Integer.parseInt(request.getParameter("status"));
		System.out.println(phone + "," + userPass+","+(status==1314));
		
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		CustomInfo customInfo = customInfoDAO.findNameAndPwd(phone, userPass);
		List<String> ssss = customInfoDAO.findWXxiaofei(phone);
        System.out.println(ssss);
		HttpSession session = request.getSession();		
		session.setAttribute("ssss", ssss);
		
		if(status==1314){
			response.setCharacterEncoding("UTF-8"); 
			String shopid = request.getParameter("shopid").trim();
			session.setAttribute("shopid", shopid);
			System.out.println("id"+shopid);
			List<String> str2 = customInfoDAO.findadvise(shopid);
			PrintWriter out = response.getWriter();
			out.print(str2);
			out.flush();
			out.close();
			session.setAttribute("advises", str2);
		}else{				
		if (customInfo == null) {
			if(customInfoDAO.checkshoujihao(phone)){
				request.setAttribute("ss", "ss");
				response.setContentType("text/html;charset=GBK");
				PrintWriter out = response.getWriter();
				out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
				out.print("<script>");
				out.print("alert('密码不正确!');");
				out.print("window.location.href='wx/reg.jsp'");
				out.print("</script>");
				out.close();	
			}else if(!customInfoDAO.checkshoujihao(phone)){
			request.setAttribute("ss", "ss");
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
			out.print("<script>");
			out.print("alert('手机号不存在!');");
			out.print("window.location.href='wx/reg.jsp'");
			out.print("</script>");
			out.close();
			}
			//response.sendRedirect("wx/reg.jsp");

		} else if (status == 2) {
			String name = customInfo.getName();
		
	
			session.setAttribute("cusInfo", customInfo);
			session.setAttribute("bound_mob", phone);
			session.setAttribute("bound_pass", userPass);
		
			String dizhi = customInfo.getAddress();
			
			if (name == null || name.trim()=="") {
				name = "无";
			}
			session.setAttribute("name", name);
			
			if (dizhi == null || dizhi.trim()=="") {
				dizhi = "无";
			}
			session.setAttribute("dizhi", dizhi);
			
			String addchepai = customInfo.getCarNo();
			if (addchepai == null || addchepai.trim()=="") {
				addchepai = "无";
			}
			
			String shoujihao = customInfo.getPhone();
//			if (shoujihao == null) {
//				shoujihao = "";
//			}
			session.setAttribute("bound_mob", shoujihao);
			session.setAttribute("addchepai", addchepai);
			session.setAttribute("dizhi", dizhi);
			response.sendRedirect("wx/userinfo.jsp");

			CustomInfoDAO customerInfoDAO = new CustomInfoDAO();
			List<String> Telmsgs = customerInfoDAO.findtelmsg(shoujihao);
			session.setAttribute("Telmsgs", Telmsgs);
		} else if (status == 1) {

	

			session.setAttribute("cusInfo", customInfo);
			int cishu = customInfo.getJf();
			System.out.println(cishu);
			session.setAttribute("bound_mob", phone);
			System.out.println(phone);
			session.setAttribute("bound_pass", userPass);
			session.setAttribute("cishu", cishu);
			response.sendRedirect("wx/choujian.jsp");

		}else if (status == 3){
		
			session.setAttribute("cusInfo", customInfo);
			response.sendRedirect("wx/baoxian.jsp");
			
		}else if(status==11){

			session.setAttribute("cusInfo", customInfo);
			session.setAttribute("bound_mob", phone);			
			session.setAttribute("bound_pass", userPass);			
			response.sendRedirect("wx/pinglun.jsp?id="+(String)session.getAttribute("shopid"));
			
		}else if(status==12){
		
			List<String> str = customInfoDAO.findtelmsg(phone);
			session.setAttribute("Telmsgs", str);

			session.setAttribute("cusInfo", customInfo);
			session.setAttribute("bound_mob", phone);
			
			session.setAttribute("bound_pass", userPass);
			
			response.sendRedirect("wx/myXiaoxi.jsp");
		}else if(status==13){
			session.setAttribute("cusInfo", customInfo);
			session.setAttribute("bound_mob", phone);			
			session.setAttribute("bound_pass", userPass);			
			response.sendRedirect("wx/xiaofei.jsp");
		}else if(status==119){
			session.setAttribute("cusInfo", customInfo);
			response.sendRedirect("wx/baoxian2.jsp");		
		}
		}
	}

}
