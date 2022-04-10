<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body bgcolor="#9acd32">
	<div style="text-align: center">
		<h1>Registracia použivateľa</h1>

		<br/>

		<h2>
			<Zadaj meno>
		</h2>

		<form action="registration" method="post">
			Meno: <input type="text" name="user_name"> <input
				type="submit" value="Odoslat">
		</form>

		<h2><c:out value="${regResult}"/> </h2>

		<form action="http://localhost:8095/" method="get">
			<input type="submit" value="Domov">
	</div>
</body>
</html>