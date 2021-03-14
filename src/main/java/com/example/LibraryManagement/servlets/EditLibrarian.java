package com.example.LibraryManagement.servlets;


import com.example.LibraryManagement.objects.Librarians;
import com.example.LibraryManagement.dao.LibrarianDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		Librarians bean=new Librarians(id,name, email, password, mobile);
		LibrarianDao.update(bean);
		response.sendRedirect("ViewLibrarian");
	}

}
