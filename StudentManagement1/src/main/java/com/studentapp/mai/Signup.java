package com.studentapp.mai;

import java.util.Scanner;

import com.studentapp.dao.StudentDaoImplement;
import com.studentapp.dto.Student;

public class Signup {

	public static void signup() {
		Scanner sc=new Scanner(System.in); 
			Student s=new Student(); 
			StudentDaoImplement st=new StudentDaoImplement();
			System.out.println("enter your name:");
			
			//String name sc.next();
			//s.setSname(name);
			
			s.setSname(sc.next());
			
			System.out.println("enter the phone:");
			
			//long phone=sc.nextLong();
			//s.setPhone(phone);
			s.setPhone(sc.nextLong());
			
			System.out.println("enter email:");
			s.setEmail(sc.next());
			
			System.out.println("enter branch:");
			s.setBranch(sc.next());
			
			System.out.println("enter location:");
			s.setLocation(sc.next());
			
			System.out.println("enter Password:");
			String password=sc.next();
			
			System.out.println("enter confirm password:");
			String confirm=sc.next();
			
			if(password.equals(confirm)) {
				s.setPassword(password);
				
				if(st.insertStudent(s)) {
					System.out.println("Signup succesfull....");
				}
				else {
					System.out.println("Signup failed...");
				}
			}
				else {
					System.out.println("password mismatched...");
				}
			
			
		}
	}

