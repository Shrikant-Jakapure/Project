package com.sunbeam.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewDao {
     public static List<Student> getAllStudent(){
    	 List<Student> list = new ArrayList<Student>();
			 Student s;
    	 try {
        	 Class.forName("com.mysql.cj.jdbc.Driver");
     		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","shrikant");
     		System.out.println("+++++++++++++"+con);
     		String sql="select * from registeruser";
     		PreparedStatement pstmt=con.prepareStatement(sql);
     		ResultSet rs=pstmt.executeQuery();
     		 while(rs.next()) {
     			  s =new Student();

     			 s.setName(rs.getString(1));
     			s.setPass(rs.getString(2));
     			s.setEmail(rs.getString(3));
     			s.setCountry(rs.getString(4));
     			list.add(s);
     			 
     		 }
     		  for (Student s1 :list) {
     			  System.out.println(s1.toString());
				
			}
     		con.close();
         }catch (ClassNotFoundException e) {
     		
     		e.printStackTrace();
     	} catch (SQLException e) {
     		
     		e.printStackTrace();
     	}
		return list;
    	 
    	 
     }
}
