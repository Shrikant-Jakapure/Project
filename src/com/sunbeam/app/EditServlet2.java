package com.sunbeam.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditServlet2() {
        super();
      
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");   
        PrintWriter out=response.getWriter();   
                 
        String name1=request.getParameter("name");      
        String pass1=request.getParameter("pass");    
        String email1=request.getParameter("email");      
        String country1=request.getParameter("country"); 
       // String name2 = request.getParameter("name");
            
        Student e1=new Student();   
            
        e1.setName(name1);     
        e1.setPass(pass1);   
        e1.setEmail(email1);     
        e1.setCountry(country1); 
       // e1.setName(name2);
            
        System.out.println("In servlet2 ="+e1.toString());
        int status=UpdateDao.update(e1);   
        if(status>0){   
            response.sendRedirect("view");   
        }else{      
            out.println("Sorry! unable to update record");      
        }   
            
        out.close();
	}

}
