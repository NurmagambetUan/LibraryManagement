package com.example.LibraryManagement.servlets;


import com.example.LibraryManagement.objects.Librarians;
import com.example.LibraryManagement.dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);
		
		request.getRequestDispatcher("navadmin.jsp").include(request, response);
		out.println("<div class='container'>");

		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		Librarians bean=new Librarians(id, name, email, password, mobile);
		LibrarianDao.save(bean);
		out.print("<h4>Librarian added successfully</h4>");
		request.getRequestDispatcher("addlibrarianform.jsp").include(request, response);
		
		
		out.println("</div>");
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
