package com.example.LibraryManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	public static Connection getCon() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibrarySystem",
					"postgres", "dbpass");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
