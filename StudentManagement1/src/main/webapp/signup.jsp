<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>
<%
if(request.getAttribute("fail")!=null){
%>
<%=request.getAttribute("fail") %>
<%
}
%>
<form action="signup" method="post">
		<input type="text" name="name" placeholder="Enter name"> <input
			type="tel" name="phone" placeholder="Enter phone"> <input
			type="text" name="email" placeholder="Enter email"> <input
			type="text" name="loc" placeholder="Enter location"> <input
			type="text" name="branch" placeholder="Enter branch"> <input
			type="password" name="password" placeholder="Enter password">
		<input type="password" name="confirm" placeholder="Enter confirm password">
		<input type="submit" value="signup">
        do you have an account? <a href="login.jsp">login</a>
	</form>
</body>
</html>