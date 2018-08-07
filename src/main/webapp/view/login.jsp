<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login | SIGA</title>
</head>
<body>
	<p>Login | SIGA</p>
	<form action="${path}/user/login" method="post" class="form-signin">
		<p style="color:red;">${error}</p>
		<p style="color:green;">${message}</p>
		<p>User Name : <input type="text" name="username" placeholder="Enter User Name"/> </p>
		<p>Password : <input type="password" name="password" placeholder="Enter Password"/> </p>
		<p>
			<input type="checkbox" name="remember-me" id="remember-me" />
			<label>Remember Me</label>
		</p>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<p><button type="submit">Login</button></p>
	</form>
</body>
</html>