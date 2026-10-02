package com.studentapp.mai;

import java.util.Scanner;

import com.studentapp.dao.StudentDao;
import com.studentapp.dao.StudentDaoImplement;
import com.studentapp.dto.Student;

public class Login {

	public static void login() {
		Scanner sc=new Scanner(System.in);
		StudentDao st=new StudentDaoImplement();
		System.out.println("enter email:");
		String email=sc.next();
		
		System.out.println("enter password:");
		String password=sc.next();
		
		Student s=st.getStudent(email,password);
		
		if(s!=null) {
			System.out.println("login succesfull....");
			while(true) {
				System.out.println("1.view profile");
				System.out.println("2.Update your account");
				System.out.println("3.Exit");
				if(s.getSid()==1) {
					System.out.println("4.View all student details");
				}
					int choice =sc.nextInt();
					
					switch(choice) {
					case 1:
						System.out.println(s);
						break;
						
					case 2:
						Update.update(s);
						break;
					
					case 3:
						System.exit(0);
						break;
						
					case 4:
						if(s.getSid()==1) {
							Retrive.retrive();
						}
						else {
							System.out.println("go with the valid choice");
						}
						break;
						
						default:
							System.out.println("choice the right option:");
						}
					}
	}
		else {
			System.out.println("Login failed..");
		}
	}
}
