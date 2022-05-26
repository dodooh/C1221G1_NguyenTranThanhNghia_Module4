<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Currency Exchange</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="display-1 mb-3">Currency Exchange</div>
        <div class="form-group col-md-4 col-md-offset-5 align-center ">
            <form action="/calc" method="get">
                <div>
                    <label for="usd">USD:</label>
                    <input type="number" name="usd" id="usd" value="${usd}">
                </div>
                <div>
                    <label for="rate">Rate:</label>
                    <input type="number" name="rate" id="rate" value="${rate}">
                </div>
                <div>
                    <button type="submit">Calc</button>
                </div>
                <c:if test="${result != null}">
                    <h1>
                        <fmt:formatNumber var="result1" value="${result}" type="number"/>
                        VND ${result1}
                    </h1>
                </c:if>
            </form>
        </div>
    </div>
</div>

</body>
</html>
