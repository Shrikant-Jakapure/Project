package com.sunbeam.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{          response.setContentType("text/html");
	           PrintWriter out = response.getWriter();
	           
		     String user = request.getParameter("username");
		     String password = request.getParameter("password");
		     
		     if (LoginDao.validate(user, password))
		     {
		    	 System.out.println("login successfull");
		    	      RequestDispatcher rd = request.getRequestDispatcher("success.html");
		    	      rd.forward(request, response);
		     }
		     else {
		    	 System.out.println("error");
		    	 RequestDispatcher rd = request.getRequestDispatcher("index.html");
	    	      rd.forward(request, response);
		    	 
		     }
		     out.close();
	}

}
