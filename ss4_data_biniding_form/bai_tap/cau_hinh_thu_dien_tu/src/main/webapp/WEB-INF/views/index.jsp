<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 5/5/2022
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Form</title>
</head>
<body>
<h1>Setting</h1>
<p style="color: green">${message}</p>
<table>
    <form:form modelAttribute="setting" action="/save" method="get">

        <tr>
            <td>Languages</td>
            <td>
                <form:select id="" path="language" itemValue="${setting.language}">
                    <form:option value="English">English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>
                Show
                <form:select id="" path="size" itemValue="${setting.size}">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                email per pages
            </td>
        </tr>
        <tr>
            <td>Spam Filter</td>
            <td>
                <form:checkbox id="spamFilters" path="spamFilters" itemValue="${setting.spamFilters}"/>
                <span>Enable Spam Filters</span>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td>
                <form:textarea type="text" path="signature" itemValue="${setting.signature}"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:button type="submit">Update</form:button></td>
            <td>
                <form:button type="button">Cancel</form:button></td>
        </tr>
    </form:form>
</table>
</body>
</html>
