package com.studentapp.mai;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the choice:");
		int choice=0;
		
		while(true) {
			System.out.println("1. Sign up");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: 
				Signup.signup();
				break;
			case 2:
				Login.login();
				break;
			case 3:
				System.exit(0);
			}
		}
	}
}
