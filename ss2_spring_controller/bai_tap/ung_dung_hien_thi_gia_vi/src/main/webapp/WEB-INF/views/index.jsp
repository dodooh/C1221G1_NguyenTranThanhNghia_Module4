<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 5/4/2022
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Condiment</title>
</head>
<body>
<form action="/save" method="post">
    <label for="Lecttuce">Lecttuce</label>
    <input id="Lecttuce" type="checkbox" name="condiment" value="Lectuce">
    <label for="Tomato">Tomato</label>
    <input id="Tomato" type="checkbox" name="condiment" value="Tomato">
    <label for="Mustard">Mustard</label>
    <input id="Mustard" type="checkbox" name="condiment" value="Mustard">
    <label for="Sprouts">Sprouts</label>
    <input id="Sprouts" type="checkbox" name="condiment" value="Sprouts">
    <hr>
    <button type="submit">Save</button>
</form>
<c:if test="${condiments ne null}">
    <ul>
        <c:forEach var="c" items="${condiments}" >
            <li>${c}</li>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>
