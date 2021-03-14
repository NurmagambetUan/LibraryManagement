package com.example.LibraryManagement.servlets;


import com.example.LibraryManagement.objects.Issues;
import com.example.LibraryManagement.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navlibrarian.jsp").include(request, response);
		
		out.println("<div class='container'>");
		
		List<Issues> list=BookDao.viewIssuedBooks();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Callno</th><th>Student Id</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>");
		for(Issues bean:list){
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentname()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td></tr>");
		}
		out.println("</table>");
		
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}
}
