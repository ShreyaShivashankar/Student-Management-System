<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>

     <link rel="stylesheet" href="style.css">
</head>

<body>

    <div class="forgot-container">

        <h2>Forgot Password?</h2>

        <p>Enter your details to reset your password</p>
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
        <form action="forgotpassword" method="post">

            <input type="email"
                   name="email"
                   placeholder="Enter Your Email"
                   required>

            <input type="tel"
                   name="phone"
                   placeholder="Enter Your Phone Number"
                   required>

            <input type="password"
                   name="password"
                   placeholder="Enter Your New Password"
                   required>

            <input type="password"
                   name="confirm"
                   placeholder="Confirm Your Password"
                   required>

            <button type="submit" value="forgot">Reset Password</button>

        </form>

        <div class="login-link">
            <a href="login.jsp">Back to Login</a>
        </div>

    </div>

</body>

</html>