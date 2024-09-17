<%--
  Created by IntelliJ IDEA.
  User: maixu
  Date: 9/18/2024
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of Books</h1>
<a href="/books?action=CREATE">Create new Book</a>
<table border="10" cellspacing="10" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Category</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Year Created</th>
        <th>Author</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="book" items="${book}">
        <tr>
            <td>${book.id}</td>
            <td>${book.categoryId.name}</td>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.stock}</td>
            <td>${book.yearCreated}</td>
            <td>${book.author}</td>
            <td>${book.status ? 'active' : 'unactive'}</td>
            <td>
                <a href="/books?action=DETAIL&id=${book.id}">Details</a> |
                <a href="/books?action=UPDATE&id=${book.id}">Edit</a> |
                <a href="/books?action=DELETE&id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
