package com.sunbeam.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Student s4;

    public EditServlet() {
        super();
        
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");     
        PrintWriter out=response.getWriter();   
        out.println("<h1>Update Student</h1>");   
        String name=request.getParameter("name");    
        //int id1=Integer.parseInt(sid);      
            System.out.println("name = "+name);
        s4 = EditDao.getStudentByName(name);      
            
        out.print("<form action='EditServlet2' method='post'>");    
        out.print("<table>");   
       // out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e1.getId1()+"'/></td></tr>");     
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+s4.getName()+"'/></td></tr>");      
        out.print("<tr><td>Pass:</td><td><input type='text' name='pass' value='"+s4.getPass()+"'/></td></tr>");      
        out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+s4.getEmail()+"'/></td></tr>");      
        out.print("<tr><td>Country:</td><td>");      
        out.print("<select name='country' style='width:150px'>");      
        out.print("<option>India</option>");      
        out.print("<option>USA</option>");      
        out.print("<option>OTHER</option>");     
             
        out.print("</select>");     
        out.print("</td></tr>");      
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");     
        out.print("</table>");      
        out.print("</form>");   
            
        out.close();    
	}

}
