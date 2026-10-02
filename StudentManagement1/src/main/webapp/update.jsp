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

<%Student s=null; %>
<%if(session.getAttribute("student")!=null){ %>
<%s=(Student)session.getAttribute("student"); %>
<%} %>
<form action="update" method="post">
	<input type="text" name="name" value="<%=s.getSname()%>">
	<input type="text" name="branch" value="<%=s.getBranch()%>">
	<input type="text" name="location" value="<%=s.getLocation()%>">
	<input type="submit" value="update">
	<a href="dashboard.jsp">Back</a>
</form>
</body>
</html>