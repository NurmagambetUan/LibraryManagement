package com.example.LibraryManagement.servlets;


import com.example.LibraryManagement.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navlibrarian.jsp").include(request, response);
		
		out.println("<div class='container'>");
		String callno=request.getParameter("callno");
		String sstudentid=request.getParameter("studentid");
		int studentid=Integer.parseInt(sstudentid);
		
		int i=BookDao.returnBook(callno,studentid);
		if(i>0){
			out.println("<h3>Book returned successfully</h3>");
		}else{
			out.println("<h3>Sorry, unable to return book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
		}
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
