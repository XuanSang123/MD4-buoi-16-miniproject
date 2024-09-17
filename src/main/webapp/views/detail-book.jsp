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
<h1>DETAIL book </h1>

<c:if test="${not empty book}">
    <table border="10" cellspacing="10" cellpadding="10">
        <tr>
            <th>ID</th>
            <td>${book.id}</td>
        </tr>
        <tr>
            <th>Tên sách</th>
            <td>${book.name}</td>
        </tr>
        <tr>
            <th>Thể loại</th>
            <td>${book.categoryId.name}</td>
        </tr>
        <tr>
            <th>Giá</th>
            <td>${book.price}</td>
        </tr>
        <tr>
            <th>Số lượng</th>
            <td>${book.stock}</td>
        </tr>
        <tr>
            <th>Số trang</th>
            <td>${book.totalPages}</td>
        </tr>
        <tr>
            <th>Năm xuất bản</th>
            <td>${book.yearCreated}</td>
        </tr>
        <tr>
            <th>Tác giả</th>
            <td>${book.author}</td>
        </tr>
        <tr>
            <th>Trạng thái</th>
            <td>${book.status ? "Đang bán" : "Ngừng bán"}</td>
        </tr>
    </table>
    <a href="books?action=GETALL">Trở về danh sách sách</a>
</c:if>
</body>
</html>
