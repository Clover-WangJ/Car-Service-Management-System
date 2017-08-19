package com.wangwang.servlet.cusInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wangwang.dao.CusInfoDAO;
import com.wangwang.dao.CustomInfoDAO;
import com.wangwang.entity.CustomInfo;
import com.wangwang.entity.Telmsg;
import com.wangwang.yanzm.HttpClientUtil;

public class WebmmyzmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String phone = request.getParameter("tel");

		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		System.out.println("查询手机"+phone);
			Random r = new Random();
			int num = r.nextInt(9000) + 1000;
			session.setAttribute("num", num);
			String url = "http://sdk105.entinfo.cn:8060/webservice.asmx/SendSMS";
			String sn = "SDK-ZJW-010-00188";
			String pass = "008451";
			String content = num + "(注册验证码)【亿人易驾】";
			HttpClientUtil htu = new HttpClientUtil();
			htu.doGet(url,"sn="+sn+"&pwd="+pass+"&mobile="+phone+"&content="+content,"gb2312");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Telmsg telmsg =new Telmsg(formatter.format(new Date()),content,phone);
			boolean saveTelmsg = customInfoDAO.saveTelmsg(telmsg);
			if(saveTelmsg){
				System.out.println("信息存储ok");
			}else{
				System.out.println("未保存");
			}
		
	}

}
