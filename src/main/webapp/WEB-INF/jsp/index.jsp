<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Plaut Projekt</title>
</head>
<body bgcolor="pink">
	<div style="text-align: center">
		<h1><%="Hlavna strana"%>
		</h1>
		<h2><%="Zvol si moznost."%>
		</h2>
		
		<br />
		
		<form method="get" action="message">
			<input type="submit" value="Historia sprav">
		</form>
		
		<br />
		
		<form method="get" action="registration">
			<input type="submit" value="Registracia">
		</form>
		
		<br />
		
		<form method="get" action="login">
			<input type="submit" value="Prihlasenie">
		</form>
		
		<h2><c:out value="${logedInInfo}"/>	</h2>
</div>
</body>
</html>