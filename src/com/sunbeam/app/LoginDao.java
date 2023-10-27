package com.sunbeam.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	public static boolean validate(String user,String password)
	{
		 boolean status =false;
	try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","shrikant");
 		System.out.println("+++++++++++++"+con);
 		String sql="select * from registeruser where name=? and pass=?";
 		PreparedStatement pstmt=con.prepareStatement(sql);
 		
 		pstmt.setString(1, user);
 		pstmt.setString(2, password);
 		
 		ResultSet rs=pstmt.executeQuery();
 		 status=rs.next();
 		
 		con.close();
     }catch (ClassNotFoundException e) {
 		
 		e.printStackTrace();
 	} catch (SQLException e) {
 		
 		e.printStackTrace();
 	}
    return status;
}
}