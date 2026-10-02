<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
<style>
    a:link,
    a:visited,
    a:hover,
    a:active {
        color: blue;
    }
</style>
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
<%
if(request.getAttribute("success")!=null){
%>
<%=request.getAttribute("success") %>
<%
}
%>

		<h1>Welcome Back</h1>

		<p>Login to your account</p>


		<form action="Login" method="post">

			<input type="text" name="identifier"
				placeholder="Enter your Email or Phone Number" required> 
				<input
				type="password" name="pwd" placeholder="Enter your password"
				required>


			<button type="submit" value="Login">Login</button>

		</form>


		<p>

			Don't have an account? <br> <a href="signup.jsp"> Sign Up </a><br>
			<a href="forgotpassword.jsp">Forgot password?</a>
		</p>
</body>
</html>