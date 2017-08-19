package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.yanzm.HttpClientUtil;

public class yanZCServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String tel = request.getParameter("tel");
		
//		String url = "http://api.mms.net.cn/WebService.asmx/SendSMS";
//		String sn = "chezhitong";
//		String pass = "chezhitong@)!#1013";
//		String content = "恭喜您已成为亿人易驾会员，用您的手机号到商家消费即可享受优惠服务，欢迎体验。更多详情请登录亿人易驾官网、微信公众号和手机客户端。【亿人易驾】";
//		HttpClientUtil htu = new HttpClientUtil();
//		htu.doGet(url, "username="+sn+"&password="+pass+"&smsphone="+tel+"&ext=&smsmemo="+content, "utf-8");
		response.sendRedirect("login.jsp");

	}

}
