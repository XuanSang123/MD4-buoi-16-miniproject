<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maixu
  Date: 9/17/2024
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>danh sach category</h1>
<a href="/">Quay lai trang chu</a>
<a href="/views/add-category.jsp">them category</a>
<table border="10" cellpadding="10" cellspacing="10">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Satus</th>
        <th colspan="3">action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ca" items="${ca}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${ca.name}</td>
            <td>${ca.status?"active":"unactive"}</td>
            <td><a href="/category?action=DETAIL&id=${ca.id}"> detail</a></td>
            <td><a href="/category?action=EDIT&id=${ca.id}">edit</a></td>
            <td><a href="/category?action=DELETE&id=${ca.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
