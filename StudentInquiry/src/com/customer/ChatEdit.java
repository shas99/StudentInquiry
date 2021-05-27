package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChatEdit
 */
@WebServlet("/ChatEdit")
public class ChatEdit extends HttpServlet {//edit chat
	private static final long serialVersionUID = 1L;
       
   


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ChatID = request.getParameter("chatID");
		String chat = request.getParameter("chat");
		int  Chatint = Integer.parseInt(ChatID);
	
		boolean isTrue;
		
		isTrue = ChatDBUtil.edidinquiry(chat, Chatint);
	
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}else {
			
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);	
		}
	
	
	}
	
	
	

}
