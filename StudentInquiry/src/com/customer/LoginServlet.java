package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		boolean istrue;
		CustomerDBUtil.validate(username,password);
		istrue = CustomerDBUtil.login();//to check if the login is successful
		
		if(istrue == true) {
		
		try {
		List<Customer> cusDetails = CustomerDBUtil.validate(username, password);
		request.setAttribute("cusDetails", cusDetails);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
		dis.forward(request,response);
		}else {
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);	
			
			
		}
	}

}