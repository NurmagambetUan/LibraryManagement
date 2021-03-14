package com.example.LibraryManagement.dao;

import com.example.LibraryManagement.objects.Books;
import com.example.LibraryManagement.objects.Issues;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	public static int save(Books bean){
		int status=0;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("insert into \"E_BOOK\" values(?,?,?,?,?,?)");
			ps.setString(1,bean.getCallno());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getAuthor());
			ps.setString(4,bean.getPublisher());
			ps.setInt(5,bean.getQuantity());
			ps.setInt(6,0);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<Books> view(){
		List<Books> list=new ArrayList<Books>();
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("select * from \"E_BOOK\"");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Books bean=new Books();
				bean.setCallno(rs.getString("callno"));
				bean.setName(rs.getString("name"));
				bean.setAuthor(rs.getString("author"));
				bean.setPublisher(rs.getString("publisher"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setIssued(rs.getInt("issued"));
				
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static int delete(String callno){
		int status=0;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("delete from \"E_BOOK\" where \"CALLNO\"=?");
			ps.setString(1,callno);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int getIssued(String callno){
		int issued=0;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("select * from \"E_BOOK\" where \"CALLNO\"=?");
			ps.setString(1,callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				issued=rs.getInt("issued");
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return issued;
	}
	public static boolean checkIssue(String callno){
		boolean status=false;
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("select * from \"E_BOOK\" where \"CALLNO\"=? and \"QUANTITY\">\"ISSUED\"");
			ps.setString(1,callno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int issueBook(Issues bean){
		String callno=bean.getCallno();
		boolean checkstatus=checkIssue(callno);
		System.out.println("Check status: "+checkstatus);
		if(checkstatus){
			int status=0;
			try{
				Connection con= Database.getCon();
				PreparedStatement ps=con.prepareStatement("insert into \"E_ISSUEBOOK\" values(?,?,?,?,?,?)");
				ps.setString(1,bean.getCallno());
				ps.setString(2,bean.getStudentid());
				ps.setString(3,bean.getStudentname());
				ps.setLong(4,bean.getStudentmobile());
				java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
				ps.setDate(5,currentDate);
				ps.setString(6,"no");
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update \"E_BOOK\" set \"ISSUED\"=? where \"CALLNO\"=?");
					ps2.setInt(1,getIssued(callno)+1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
		}else{
			return 0;
		}
	}
	public static int returnBook(String callno,int studentid){
		int status=0;
			try{
				Connection con= Database.getCon();
				PreparedStatement ps=con.prepareStatement("update \"E_ISSUEBOOK\" set \"RETURNSTATUS\" ='yes' where \"CALLNO\"=? and \"STUDENTID\"=?");
				ps.setString(1,callno);
				ps.setInt(2,studentid);
				
				status=ps.executeUpdate();
				if(status>0){
					PreparedStatement ps2=con.prepareStatement("update \"E_BOOK\" set \"ISSUED\"=? where \"CALLNO\"=?");
					ps2.setInt(1,getIssued(callno)-1);
					ps2.setString(2,callno);
					status=ps2.executeUpdate();
				}
				con.close();
				
			}catch(Exception e){System.out.println(e);}
			
			return status;
	}
	public static List<Issues> viewIssuedBooks(){
		List<Issues> list=new ArrayList<Issues>();
		try{
			Connection con= Database.getCon();
			PreparedStatement ps=con.prepareStatement("select * from \"E_ISSUEBOOK\" order by \"ISSUEDATE\" desc");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Issues bean=new Issues();
				bean.setCallno(rs.getString("callno"));
				bean.setStudentid(rs.getString("studentid"));
				bean.setStudentname(rs.getString("studentname"));
				bean.setStudentmobile(rs.getLong("studentmobile"));
				bean.setIssueddate(rs.getDate("issueddate"));
				bean.setReturnstatus(rs.getString("returnstatus"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
}
