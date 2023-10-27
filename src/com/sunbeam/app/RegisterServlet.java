package com.sunbeam.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		   PrintWriter out =response.getWriter();
		   
	     String username = request.getParameter("username");
	     String pass = request.getParameter("pass");
	     String email = request.getParameter("email");
	     String country = request.getParameter("country");
	     
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","shrikant");
	 		System.out.println("+++++++++++++"+con);
	 		String insertQuery="insert into registeruser values(?,?,?,?)";
	 		PreparedStatement pstmt=con.prepareStatement(insertQuery);
	 		
	 		pstmt.setString(1, username);
	 		pstmt.setString(2, pass);
	 		pstmt.setString(3, email);
	 		pstmt.setString(4, country);
	 		int updateRowCount=pstmt.executeUpdate();
	 		System.out.println("Total number of rows affected are: "+updateRowCount);
	 		System.out.println("user registered successfully");
	 	    response.sendRedirect("login.html");
	 		con.close();
	     }catch (ClassNotFoundException e) {
	 		
	 		e.printStackTrace();
	 	} catch (SQLException e) {
	 		
	 		e.printStackTrace();
	 	}
	}

}
