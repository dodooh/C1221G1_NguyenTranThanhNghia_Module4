<jsp:useBean id="declaration" scope="request" type="com.codegym.model.Declaration"/>
<%--
  Created by IntelliJ IDEA.
  User: King
  Date: 5/5/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<h1>View Declaration</h1>
<p style="color: blue">${message}</p>
<div>Ho va ten: ${declaration.name}</div>
<div>Gioi Tinh: ${declaration.gender}</div>
<div>Nam Sinh: ${declaration.yearOfBirth}</div>
<div>Quoc Tich: ${declaration.nation}</div>
<div>So CMND hoac CCCD: ${declaration.nationalId}</div>
<div>Thong Tin Di Lai: ${declaration.transport}</div>
<div>So Hieu Phuong Tien: ${declaration.transportNumber}</div>
<div>So Ghe: ${declaration.seat}</div>
<div>Ngay Khoi Hanh: ${declaration.startDay} - ${declaration.startMonth} - ${declaration.startYear}  </div>
<div>Ngay Ket Thuc: ${declaration.endDay} - ${declaration.endMonth} - ${declaration.endYear}  </div>
<div>Trong 14 ngay qua anh Chi di qua thanh pho nao: ${declaration.gotoCity}</div>
<a href="/create">Edit</a>
</body>
</html>
