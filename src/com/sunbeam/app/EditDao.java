package com.sunbeam.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDao {
	 public static Student getStudentByName(String name){      
	        Student s3=new Student();
	        
	        try {
	       	 Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","shrikant");
	    		System.out.println("+++++++++++++"+con);
	    		String sql="select * from registeruser where name=?";
	    		PreparedStatement pstmt=con.prepareStatement(sql);
	    		pstmt.setString(1,name);   
	    		 ResultSet rs1=pstmt.executeQuery();   
	             if(rs1.next()){    
	                 s3.setName(rs1.getString(1));      
	                 s3.setPass(rs1.getString(2));   
	                 s3.setEmail(rs1.getString(3));    
	                 s3.setCountry(rs1.getString(4));      
	             }  
//	    		 while(rs.next()) {
//	    			 Student s =new Student();
//	    			 s.setName(rs.getString(1));
//	    			s.setPass(rs.getString(2));
//	    			s.setEmail(rs.getString(3));
//	    			s.setCountry(rs.getString(4));
//	    			list.add(s);
//	    			 
//	    		 }
//	    		  for (Student s :list) {
//	    			  System.out.println(s.toString());
//	   			
//	   		}
	    		con.close();
	        }catch (ClassNotFoundException e) {
	    		
	    		e.printStackTrace();
	    	} catch (SQLException e) {
	    		
	    		e.printStackTrace();
	    	}        
	        
			return s3; 
	 }

}
