<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.studentapp.dto.Student" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>View Students</title>
<style>

body { font-family: "Segoe UI", system-ui, sans-serif; font-weight: 400; background: #f8f7fc; color: #4b4868; margin: 0; padding: 40px 20px; }
.container { max-width: 1000px; margin: auto; background: #fff; padding: 32px; border-radius: 16px; border: 1px solid #ece9f6; }
h1 { font-weight: 400; font-size: 26px; margin: 0; }
table { width: 100%; border-collapse: collapse; margin-top: 22px; }
th { background: #e6e1f7; color: #4b4868; padding: 12px; text-align: left; font-weight: 400; }
td { padding: 12px; border-bottom: 1px solid #ece9f6; }
a { color: #8b7fd0; text-decoration: none; }
.back-btn { display: inline-block; margin-top: 22px; padding: 10px 20px; background: #e6e1f7; color: #4b4868; border-radius: 10px; }
.back-btn:hover { background: #dcd5f3; }
</style>
</head>

<body>

<div class="container">

<h1>Student Records</h1>

<%
ArrayList<Student> list =
    (ArrayList<Student>) request.getAttribute("sdlist");
%>

<table>

<thead>

<tr>
    <th>SID</th>
    <th>Name</th>
    <th>Phone</th>
    <th>Email</th>
    <th>Branch</th>
    <th>Location</th>
    <th>Action</th>
</tr>

</thead>

<tbody>

<%

if (list != null) {

    for (Student st : list) {

%>


<tr>

    <td><%=st.getSid()%></td>

    <td><%=st.getSname()%></td>

    <td><%=st.getPhone()%></td>

    <td><%=st.getEmail()%></td>

    <td><%=st.getBranch()%></td>

    <td><%=st.getLocation()%></td>
	
	<td><button><a href="Delete?Sid=<%=st.getSid()%>">Delete</a></button></td>
	
</tr>

<%

    }

} else {

%>

<tr>

    <td colspan="7">
        No students found.
    </td>

</tr>

<%

}

%>

</tbody>

</table>

<a href="dashboard.jsp" class="back-btn">
    Back to Dashboard
</a>

</div>
<% 
if(request.getParameter("sucess")!=null){
%>
<%= request.getParameter("sucess")%>
<%} %>

</body>

</html>