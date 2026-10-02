package com.studentapp.mai;

import java.util.ArrayList;

import com.studentapp.dao.StudentDao;
import com.studentapp.dao.StudentDaoImplement;
import com.studentapp.dto.Student;

public class Retrive {
public static void retrive() {
	StudentDao st=new StudentDaoImplement();
	
	ArrayList<Student>list=st.getStudent();
	for (Student s : list) {
        System.out.println(s);
	}
}
}
