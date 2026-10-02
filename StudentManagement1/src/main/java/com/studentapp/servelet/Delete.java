package com.studentapp.servelet;

import java.io.IOException;

import com.studentapp.dao.StudentDao;
import com.studentapp.dao.StudentDaoImplement;
import com.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("Sid"));
		Student s1=new Student();
		s1.setSid(id);
		StudentDao st=new StudentDaoImplement();
		if(st.deleteStudent(s1)) {
//			RequestDispatcher rd=req.getRequestDispatcher("viewstudents.jsp");
//			req.setAttribute("sucess", "Delete sucessfull");
			resp.sendRedirect("viewstudents?sucess=Deleted successfully");
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("viewstudents.jsp");
			req.setAttribute("fail", "Unable to delete the details");
			rd.forward(req, resp);
		}
	}

}
