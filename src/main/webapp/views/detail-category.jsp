<%--
  Created by IntelliJ IDEA.
  User: maixu
  Date: 9/17/2024
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/category?action=GETALL">quai lai danh sach</a>

<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Satus</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="ca" items="${ca}" varStatus="loop">
        <tr>
            <td>${ca.id}</td>
            <td>${ca.name}</td>
            <td>${ca.status?"active":"unactive"}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
