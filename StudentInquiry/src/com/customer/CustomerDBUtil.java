package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean suc;
	private static String username; 
	private static int SID;
public static List<Customer> validate(String userName,String password){//login
	
	
	ArrayList<Customer> cus = new ArrayList<>();
	
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			suc = false;
			
			String sql = "select * from student where userName='"+userName+"'and password='"+password+"'";
	
			rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email=rs.getString(3); 
				String phone = rs.getString(4);
				String userU = rs.getString(5);
				String passU = rs.getString(6);
				username = name;
				SID = id;
				Customer c = new Customer(id,name,email,phone,userU,passU);//creating customer object
				cus.add(c);
				suc = true;//if login is successful
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cus;
	}

	public static int ID() {
		
		int x = SID;
		
		return x;
		
	}
	
	
	public static String username() {
		
		String name = username;
		return name;
		
		
	}



	public static boolean login() {//if the login is sucessful
		boolean x;
		
		x = suc; 
		return x;
	}












   

	public static boolean insertcustomer(String name,String email,String phone,String username,String password){//not needed
		
		boolean isSuccess = false;
		
		
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "Insert into student values (0,'"+name+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
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
	




	public static boolean updatecustomer(String id, String name, String email, String phone, String username, String password) {//not needed
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "update student set email='"+email+"',studentName='"+name+"',phoneNumber='"+phone+"',userName='"+username+"',password='"+password+"'"
					+ "where idstudent='"+id+"'";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}


	public static List<Customer> getCustomerDetails(String ID){//retreve customer details
		
		int convertedID = Integer.parseInt(ID);
		
		ArrayList<Customer> cus = new ArrayList<>();	
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from student where idstudent='"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);	
			
				Customer c = new Customer(id,name,email,phone,username,password);
				cus.add(c);
				
			}
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
	
		return cus;
	}

}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

