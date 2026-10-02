package com.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentapp.conn.Connect;
import com.studentapp.dto.Student;

// it showed error becoz it was implementing a interface(StudentDao) ,which didn't 
//had any implementation so we extracted all the unimplemented methods and gave implements 

public class StudentDaoImplement implements StudentDao {

	Connection con=null;
	private Student s;
	public StudentDaoImplement() {
		con=Connect.getconn();
	}
	@Override
	public boolean insertStudent(Student s) {
		// TODO Auto-generated method stub
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps=null;
		int res=0;
			try {
				ps=con.prepareStatement(query);
				String name=s.getSname();
//				ps.setString(1, name);
				ps.setString(1,s.getSname());
				ps.setLong(2,s.getPhone());
				ps.setString(3,s.getEmail());
				ps.setString(4,s.getBranch());
				ps.setString(5,s.getLocation());
				ps.setString(6,s.getPassword());

				res=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(res>0) {
				return true;
			}
			else {
		return false;
	}
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		String query="UPDATE STUDENT SET SNAME=?, BRANCH=?, LOCATION=?, PASSWORD=? WHERE SID=?";
		
		PreparedStatement ps=null;
		int res=0;
		
		try {

		    ps = con.prepareStatement(query);

		    ps.setString(1, s.getSname());
		    ps.setString(2, s.getBranch());
		    ps.setString(3, s.getLocation());
		    ps.setString(4, s.getPassword());
		    ps.setInt(5, s.getSid());

		    res = ps.executeUpdate();

		} catch (SQLException e) {

		    e.printStackTrace();
		    System.out.println("UPDATE ERROR: " + e.getMessage());
		
		}
		if(res>0) {
		return true;
	}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(Student s) {
		String query = "Delete from student where sid=? and sid!=1";
		PreparedStatement ps = null;
		int res = 0;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, s.getSid());

			res = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res > 0)
			return true;
		else
			return false;
		
	}

	@Override
	public Student getStudent(String email, String password) {
		// TODO Auto-generated method stub
		String query="SELECT * FROM STUDENT WHERE EMAIL=? AND PASSWORD=?";
		PreparedStatement ps=null;
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Student();
//				int id=rs.getInt("sid");
//				s.setSid(id);
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setPhone(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
		
	}

	@Override
	public Student getStudent(String email, long phone) {
		// TODO Auto-generated method stub
		PreparedStatement p = null;

		Student s = null;

		String query = "SELECT * FROM STUDENT WHERE EMAIL=? and phone=?";
		try {
			p = con.prepareStatement(query);
			p.setString(1, email);
			p.setLong(2, phone);

			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setPhone(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	
	}

	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		
		ArrayList<Student> list = new ArrayList<Student>();
		String query="select * from student where sid!=1";
		
		PreparedStatement ps=null;
		
		try {
			ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				   s.setSid(rs.getInt("sid"));
				   s.setSname(rs.getString("sname"));
				   s.setPhone(rs.getLong("phone"));
				   s.setBranch(rs.getString("branch"));
				   s.setLocation(rs.getString("location"));
				   s.setPassword(rs.getString("password"));
				   s.setDate(rs.getString("date"));
				   list.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
