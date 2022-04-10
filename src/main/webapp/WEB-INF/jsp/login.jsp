<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOG IN</title>
</head>
<body bgcolor="pink">
	<div style="text-align: center">
		<h1>Prihlasenie</h1>

		<br/>
		
		<h2><Zadaj meno></h2>
		
		<form action="login" method="post">
			Meno: <input type="text" name="user_name"> 
				  <input id="semienko" type="submit" value="Odoslat">
		</form>

		<h2><c:out value="${logedInInfo}"/>	</h2>

		<form action="http://localhost:8095/" method="get">
			<input type="submit" value="Domov">
	</div>
</body>
</html>