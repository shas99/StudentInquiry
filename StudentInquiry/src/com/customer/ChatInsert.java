package com.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ChatInsert
 */
@WebServlet("/ChatInsert")
public class ChatInsert extends HttpServlet {//insert chat
	private static final long serialVersionUID = 1L;
       
   
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String chat = request.getParameter("Inquiry");
		
		boolean isTrue;
		
		
		isTrue = ChatDBUtil.insertcustomer(chat);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
			
		}
		
	}

}
