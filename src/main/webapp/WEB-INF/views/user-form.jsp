<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Register User</h1>
	
	<form action="/submit-user-registration" method="get">
		<p>
			<label for="firstname">First Name:</label> <input id="firstname" name="firstname" required minlength="2" maxlength="10"/>
		</p>
		<p>
			<label>Last Name:</label> <input name="lastname" pattern="[A-Z][a-z]*" />
		</p>
		<p>
			<label>Email:</label> <input type="email" name="email" />
		</p>
		<p>
			<label>Age:</label> <input type="number" name="age" min="1" max="200" step="1"/>
		</p>
		<p>
			<label>Password:</label> <input type="password" name="password" />
		</p>
		<p>
			<button>Submit</button>
		</p>
	</form>
</body>
</html>