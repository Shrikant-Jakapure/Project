package com.sunbeam.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDao {
	
	public static int update(Student s2)
	{	
		int status=0;
	 try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","shrikant");
 		System.out.println("+++++++++++++"+con);
 		String sql="update registeruser set name=?,pass=?,email=?,country=? where name=?";
 		PreparedStatement pstmt=con.prepareStatement(sql);
 		pstmt.setString(1,s2.getName());   
 		pstmt.setString(2,s2.getPass());     
 		pstmt.setString(3,s2.getEmail());      
 		pstmt.setString(4,s2.getCountry()); 
 		pstmt.setString(5, s2.getName());
 		
 		
            status= pstmt.executeUpdate();
// 		 while(rs.next()) {
// 			 Student s =new Student();
// 			 s.setName(rs.getString(1));
// 			s.setPass(rs.getString(2));
// 			s.setEmail(rs.getString(3));
// 			s.setCountry(rs.getString(4));
// 			list.add(s);
// 			 
// 		 }
// 		  for (Student s :list) {
// 			  System.out.println(s.toString());
//			
//		}
 		con.close();
     }catch (ClassNotFoundException e) {
 		
 		e.printStackTrace();
 	} catch (SQLException e) {
 		
 		e.printStackTrace();
 	}
	return status;

}
}