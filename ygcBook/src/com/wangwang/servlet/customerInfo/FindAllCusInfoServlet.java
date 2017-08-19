package com.wangwang.servlet.customerInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.CustomerInfoDAO;
import com.wangwang.entity.CustomerInfo;

@SuppressWarnings("serial")
public class FindAllCusInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomerInfoDAO customerInfoDAO = new CustomerInfoDAO();
		List<CustomerInfo> customerInfos = customerInfoDAO.findAll();
		
		request.setAttribute("customerInfos", customerInfos);
		request.getRequestDispatcher("cusInfoJsp/cusList.jsp").forward(request, response);
		
	}

}
