<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vypis z DB</title>
</head>
<body bgcolor="#9acd32">
<div style="text-align: center">
    <h1>Výpis správ pre použivateľa</h1>

    <br/>

    <h3>Vypis pre:<c:out value="${user_name}"/></h3>
    <table border="1" align="center">
        <th>Messages</th>
        <c:forEach items="${list}" var="listOfMessages">
            <tr>
                <td>${listOfMessages.data}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <form action="http://localhost:8095/" method="get">
        <input type="submit" value="Domov">
</div>
</body>
</html>
