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
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		    StudentDao st = new StudentDaoImplement();

		    HttpSession session = req.getSession(false);

		    Student s = (Student) session.getAttribute("student");

		    s.setSname(req.getParameter("name"));
		    s.setBranch(req.getParameter("branch"));
		    s.setLocation(req.getParameter("location"));

		    if (st.updateStudent(s)) {

		        session.setAttribute("student", s);

		        resp.sendRedirect("dashboard.jsp");

		    } else {

		        resp.getWriter().println("UPDATE FAILED");
		    }
		}
}
