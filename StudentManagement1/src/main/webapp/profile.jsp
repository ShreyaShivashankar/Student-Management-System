<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="com.studentapp.dto.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="style.css">
</head>
<body>
<%Student s=(Student)session.getAttribute("student"); %>

<table>
<thead>
<tr>
<th>Sid</th>
<th>Name</th>
<th>Phone</th>
<th>Email</th>
<th>Location</th>
<th>Branch</th>
</tr>

<tr>
<td><%=s.getSid() %></td>
<td><%=s.getSname() %></td>
<td><%=s.getPhone() %></td>
<td><%=s.getEmail() %></td>
<td><%=s.getLocation() %></td>
<td><%=s.getBranch() %></td>
</tr>
</thead>

<a href="dashboard.jsp" type="submit">Back</a>
</table>




</body>
</html>