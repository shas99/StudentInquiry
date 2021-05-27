package com.customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChatDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
public static boolean insertcustomer(String chat){//insert
		
		boolean isSuccess = false;
		
		
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			int studentID = 1;
			studentID = CustomerDBUtil.ID();//getting studentID
			
			String username = "Test";//
			username = CustomerDBUtil.username();//getting student username
			String sql = "Insert into inquiry values (0,'"+chat+"','"+studentID+"','"+username+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
				
			}
			
		}
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		return isSuccess;
	}

public static boolean deletecustomer(String ID){//deleting the inquiry
	
	boolean isSuccess = false;
	
	int id = Integer.parseInt(ID);
	
	try {
		
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		
		String sql = "delete from inquiry where idinquiry='"+id+"'";
		int rs = stmt.executeUpdate(sql);
		
		if(rs > 0) {
			isSuccess = true;
		}
		else {
			isSuccess = false;
			
		}
		
	}
	catch(Exception e){
		
		e.printStackTrace();
		
	}
	return isSuccess;
}

public static List<Chat> getchatDetails( ){//not needed
	
	
	ArrayList<Chat> stu = new ArrayList<>();
	
	try {
		
		con = DBConnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from inquiry where studentID = 1";
		rs = stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			int chatID = rs.getInt(1);
			String chat = rs.getString(2);
			String studentID = String.valueOf(rs.getInt(3));
			String username = rs.getString(4);
			
			Chat c = new Chat(chatID,chat,studentID,username);
			
			stu.add(c);
		
		}
	}
	catch(Exception e) {
		e.printStackTrace();	
		
	}
	 
	
	return stu;
}
	

	public static boolean edidinquiry(String Chat, int ID) {//not needed
		
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
		
			String sql = "update inquiry set inquiry='"+Chat+"'"+"where idinquiry='"+ID+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return isSuccess;
	}





}
