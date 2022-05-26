<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 4/29/2022
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="display-flex flex-column align-items-center justify-content-center">
        <div class="display-3">Dictionary</div>
        <div class="form-group col-md-4 col-md-offset-5 align-center ">
            <form action="/translate" method="get">
                <input type="search" class="form-item" name="word">
                <button type="submit">Search</button>
            </form>
        </div>
        <c:if test="${result ne null}">
        <div class="alert alert-success">
            ${result}
        </div>
        </c:if>
        <c:if test="${result == 'NOT FOUND'}">
            <div class="alert alert-danger">
                    Not Found
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
