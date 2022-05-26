<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 5/4/2022
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calc" method="post">
    <input type="number" name="number1" placeholder="Number1" value="${number1}">
    <input type="number" name="number2" placeholder="Number2" value="${number2}">
    <br>
    <input type="submit" name="operator" value="Addition(+)">
    <input type="submit" name="operator" value="Subtraction(-)">
    <input type="submit" name="operator" value="Multiplication(*)">
    <input type="submit" name="operator" value="Division(/)">
</form>
<div>
    <c:choose>
        <c:when test="${error != null}">
            <div style="color:red">${error}</div>
        </c:when>
        <c:otherwise>
            Result ${operator}: <span style="color:blue">${result}</span>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
