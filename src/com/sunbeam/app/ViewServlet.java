package com.sunbeam.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewServlet() {
        super();
        
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>StudentList<h1>");
		List<Student> list=ViewDao.getAllStudent();
		System.out.println(list);
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Name</th><th>pass</th><th>email</th><th>country</th><th>Edit</th><th>Delete</th>");
		for(Student s:list) {
			out.print("<tr><td>"+s.getName()+"</td><td>"+s.getPass()+"</td><td>"+s.getEmail()+"</td><td>"+s.getCountry()+
			"</td><td><a href='EditServlet?name="+s.getName()+"'>edit</a></td><td><a href='DeleteServlet?name="+s.getName()+"'>delete</a></td></tr>");
             
		}
		 out.print("</table>");
         
		out.close();
	}

}
