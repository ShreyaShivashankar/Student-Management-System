package com.studentapp.mai;

import java.util.Scanner;

import com.studentapp.dao.StudentDao;
import com.studentapp.dao.StudentDaoImplement;
import com.studentapp.dto.Student;

public class Update {

	public static void update(Student s) {
		Scanner sc=new Scanner(System.in);
		StudentDao st=new StudentDaoImplement();
		System.out.println("enter the new sname:");
		s.setSname(sc.next());
		System.out.println("enter phone:");
		s.setPhone(sc.nextLong());
		System.out.println("enter new email:");
		s.setEmail(sc.next());
		System.out.println("enter branch:");
		s.setBranch(sc.next());
		System.out.println("enter Location:");
		s.setLocation(sc.next());
		
		if(st.updateStudent(s)) {
			System.out.println("update successfully.....");
		}
		else {
			System.out.println("Update failed.....");
		}
	}
}
