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
//		String content = "��ϲ���ѳ�Ϊ�����׼ݻ�Ա���������ֻ��ŵ��̼����Ѽ��������Żݷ��񣬻�ӭ���顣�����������¼�����׼ݹ�����΢�Ź��ںź��ֻ��ͻ��ˡ��������׼ݡ�";
//		HttpClientUtil htu = new HttpClientUtil();
//		htu.doGet(url, "username="+sn+"&password="+pass+"&smsphone="+tel+"&ext=&smsmemo="+content, "utf-8");
		response.sendRedirect("login.jsp");

	}

}
