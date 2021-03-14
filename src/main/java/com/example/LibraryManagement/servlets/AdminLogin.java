package com.example.LibraryManagement.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);

		request.getRequestDispatcher("navhome.jsp").include(request, response);
		out.println("<div class='container'>");
		request.getRequestDispatcher("adminloginform.jsp").include(request, response);
		out.println("</div>");

		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("admin@gmail.com") && password.equals("admin")){
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			
			request.getRequestDispatcher("navadmin.jsp").include(request, response);
			request.getRequestDispatcher("admin.jsp").include(request, response);
			
		}else{
			request.getRequestDispatcher("navhome.jsp").include(request, response);
			out.println("<div class='container'>");
			out.println("<h1>Email or password is wrong</h1>");
			request.getRequestDispatcher("adminloginform.jsp").include(request, response);
			out.println("</div>");
		}
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
