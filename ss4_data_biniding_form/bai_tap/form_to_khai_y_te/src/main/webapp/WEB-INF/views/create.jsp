<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 5/5/2022
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%

%>
<html>
<head>
    <title>Khai Bao Y Te</title>
</head>
<body>
<div>
    <h1>TO KHAI Y TE</h1>
    <%--@elvariable id="declaration" type="com.codegym.model.Declaration"--%>
    <form:form action="/save" method="post" modelAttribute="declaration">
        <table>

            <tr>
                <td> Ho Va Ten (Ghi IN HOA)
                </td>
                <td>
                    <form:input path="name" itemValue="${declaration.name}"/>

                </td>
            </tr>
            <tr>
                <td>Nam Sinh</td>
                <td>
                    <form:input path="yearOfBirth" itemValue="${declaration.yearOfBirth}"/>
                </td>
            </tr>
            <tr>
                <td>Gioi Tinh</td>
                <td>
                    <form:select path="gender" itemValue="${declaration.gender}">
                        <form:option value="1">Nam</form:option>
                        <form:option value="2">Nu</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Quoc Tich</td>
                <td>
                    <form:select path="nation" itemValue="${declaration.nation}">
                        <form:options items="${referenceData.get('countryList')}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td> So CMND hoac CCCD</td>
                <td>
                    <form:input path="nationalId" itemValue="${declaration.nationalId}"/>
                </td>
            </tr>
            <tr>
                <td> Thong Tin Di Lai
                </td>
                <td>
                    <form:radiobuttons path="transport"
                                       items="${referenceData.get('transportList')}"/>
                </td>
            </tr>
            <tr>
                <td>So Hieu Phuong Tien</td>
                <td>
                    <form:input path="transportNumber" itemValue="${declaration.transportNumber}"/>
                </td>
            </tr>

            <tr>
                <td>So Ghe</td>
                <td>
                    <form:input path="seat" itemValue="${declaration.seat}"/>
                </td>
            </tr>
            <tr>
                <td>
                    Ngay Khoi Hanh
                </td>
                <td>
                    <form:select path="startDay" itemValue="${declaration.startDay}">
                        <form:options items="${referenceData.get('dayList')}"/>
                    </form:select>
                    <form:select path="startMonth" itemValue="${declaration.startMonth}">
                        <form:options items="${referenceData.get('monthList')}"/>
                    </form:select>
                    <form:select path="startYear" itemValue="${declaration.startYear}">
                        <form:options items="${referenceData.get('yearList')}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    Ngay Ket Thuc
                </td>
                <td>
                    <form:select path="endDay" itemValue="${declaration.endDay}">
                        <form:options items="${referenceData.get('dayList')}"/>
                    </form:select>
                    <form:select path="endMonth" itemValue="${declaration.endMonth}">
                        <form:options items="${referenceData.get('monthList')}"/>
                    </form:select>
                    <form:select path="endYear" itemValue="${declaration.endYear}">
                        <form:options items="${referenceData.get('yearList')}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Trong 14 ngay qua anh Chi di qua thanh pho nao</td>
                <td>
                    <form:input path="gotoCity" itemValue="${declaration.gotoCity}"/>
                </td>
            </tr>
        </table>
        <button type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>
