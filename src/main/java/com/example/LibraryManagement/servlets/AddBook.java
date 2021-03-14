package com.example.LibraryManagement.servlets;

import com.example.LibraryManagement.objects.Books;
import com.example.LibraryManagement.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();


		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navlibrarian.jsp").include(request, response);
		
		out.println("<div class='container'>");
		String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		Books bean=new Books(callno,name,author,publisher,quantity);
		int i=BookDao.save(bean);
		if(i>0){
			out.println("<h3>Book saved successfully</h3>");
		}
		request.getRequestDispatcher("addbookform.jsp").include(request, response);
		out.println("</div>");
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
