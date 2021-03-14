package com.example.LibraryManagement.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddLibrarianForm")
public class AddLibrarianForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);
		
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		out.println("<div class='container'>");
		request.getRequestDispatcher("addlibrarianform.jsp").include(request, response);
		out.println("</div>");
		
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
