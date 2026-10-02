package com.studentapp.dao;

import java.util.ArrayList;

import com.studentapp.dto.Student;

public interface StudentDao {

	//sign-up 
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	
	//login
	public Student getStudent(String email,String password);
	
	//forgot password
	public Student getStudent(String email,long phone);
	
	//details of all the students so we stoe in the form of array so we use array-list
	public ArrayList<Student> getStudent(); 
}
