package com.studentapp.servelet;

import java.io.IOException;
import java.util.ArrayList;

import com.studentapp.dao.StudentDao;
import com.studentapp.dao.StudentDaoImplement;
import com.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewstudents")
public class viewstudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao st=new StudentDaoImplement();
		ArrayList<Student> list=st.getStudent();
		
		if(list!=null) {
			RequestDispatcher rd=req.getRequestDispatcher("viewstudents.jsp");
			req.setAttribute("sdlist", list);
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("viewstudents.jsp");
			req.setAttribute("error","no student found");
			rd.forward(req,resp);
		}
	}

}
