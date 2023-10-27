package com.sunbeam.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
	 public static int delete1(String name){     
	        int status=0;   
	
	try {
   	 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","shrikant");
		System.out.println("+++++++++++++"+con);
		String sql="delete from registeruser where name=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,name);   
        status= pstmt.executeUpdate();

		con.close();
    }catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
  return status;
}
}