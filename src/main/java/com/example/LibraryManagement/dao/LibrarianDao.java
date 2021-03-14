package com.example.LibraryManagement.dao;

import com.example.LibraryManagement.objects.Librarians;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibrarianDao {

	public static int save(Librarians bean){
		int status=0;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("insert into \"E_LIBRARIAN\"(\"ID\",\"NAME\",\"EMAIL\",\"PASSWORD\",\"MOBILE\") values(?,?,?,?,?)");
			ps.setInt(1,bean.getId());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getPassword());
			ps.setLong(5,bean.getMobile());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(Librarians bean){
		int status=0;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("update \"E_LIBRARIAN\" set \"NAME\"=?,\"EMAIL\"=?,\"PASSWORD\"=?,\"MOBILE\"=? where \"ID\"=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getEmail());
			ps.setString(3,bean.getPassword());
			ps.setLong(4,bean.getMobile());
			ps.setInt(5,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<Librarians> view(){
		List<Librarians> list = new ArrayList<>();
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("select * from \"E_LIBRARIAN\"");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Librarians bean=new Librarians();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static Librarians viewById(int id){
		Librarians bean=new Librarians();
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("select * from \"E_LIBRARIAN\" where \"ID\"=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPassword(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobile(rs.getLong(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("delete from \"E_LIBRARIAN\" where \"ID\"=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email, String password){
		boolean status = false;
		try{
			Connection con = Database.getCon();
			PreparedStatement ps = con.prepareStatement("select * from \"E_LIBRARIAN\" where \"EMAIL\"=? and \"PASSWORD\"=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
}
