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

public class yanZMServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String phone = request.getParameter("tel");
		System.out.println(phone);
		CustomInfoDAO customInfoDAO = new CustomInfoDAO();
		CustomInfo customInfoP = customInfoDAO.findPwd(phone);
		System.out.println("注册手机"+phone);
		if (customInfoP != null) {
			System.out.println("手机已注册");
			//request.setAttribute("customInfoP", customInfoP);
			response.setContentType("text/html;charset=GBK");
			PrintWriter out = response.getWriter();
			out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=GBK'>");			
			out.print("<script>");
			out.print("alert('手机号已注册!');");
			out.print("window.location.href='wx/reg.jsp'");
			out.print("</script>");
			out.close();
		} else {

			Random r = new Random();
			int num = r.nextInt(9000) + 1000;
			session.setAttribute("num", num);
			String url = "http://sdk105.entinfo.cn:8060/webservice.asmx/SendSMS";
			String sn = "SDK-ZJW-010-00188";
			String pass = "008451";
			String content = num + "(注册验证码)【亿人易驾】";
			HttpClientUtil htu = new HttpClientUtil();
			htu.doGet(url,"sn="+sn+"&pwd="+pass+"&mobile="+phone+"&content="+content,"gb2312");
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Telmsg telmsg =new Telmsg(formatter.format(new Date()),content,phone);
			boolean saveTelmsg = customInfoDAO.saveTelmsg(telmsg);
			if(saveTelmsg){
				System.out.println("信息存储ok");
			}else{
				System.out.println("未保存");
			}
		}
	}

}
