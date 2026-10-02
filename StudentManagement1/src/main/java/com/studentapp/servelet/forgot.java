package com.studentapp.servelet;

	import java.io.IOException;
	import java.io.PrintWriter;

	import com.studentapp.dao.StudentDao;
	import com.studentapp.dao.StudentDaoImplement;
	import com.studentapp.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	@WebServlet("/forgotpassword")
	public class forgot  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao st=new StudentDaoImplement();
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		Student s=st.getStudent(email,phone);
		PrintWriter out=resp.getWriter();
		
		if(s!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))) {
				if (s.getPassword() != null &&
					    s.getPassword().equals(req.getParameter("confirm"))) {
//					out.print("This password is already used");
					RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
	    			req.setAttribute("fail", "this password is already used");
	    			rd.forward(req, resp);

				}else {
					s.setPassword(req.getParameter("confirm"));
					if(st.updateStudent(s)) {
//						out.print("password updated");
						RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		    			req.setAttribute("success", "password updated");
		    			rd.forward(req, resp);

					}
					else {
//						out.print("some thing went wrong....");
						RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
		    			req.setAttribute("fail", "something went wrong");
		    			rd.forward(req, resp);

					}
				}
			}else {
//				out.print("password missmatch");
				RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
    			req.setAttribute("fail", "password mismatch");
    			rd.forward(req, resp);
			}
		}else {
//			out.print("no data found..");
			RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.jsp");
			req.setAttribute("fail", "no student present with these credential ");
			rd.forward(req, resp);
		}	
		
	}
	}
	
	


