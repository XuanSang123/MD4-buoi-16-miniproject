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
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 20px;
    }

    h1 {
        color: #333;
    }

    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        margin: auto;
    }

    label {
        display: block;
        margin-top: 10px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="number"],
    select {
        width: 100%;
        padding: 8px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    a {
        display: inline-block;
        margin-top: 10px;
        text-decoration: none;
        color: #007BFF;
    }

    a:hover {
        text-decoration: underline;
    }
</style>

<body>
<h1>Chỉnh sửa sách</h1>
<form action="books?action=UPDATE" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${book.id}">

    <label for="name">Tên sách:</label>
    <input type="text" id="name" name="name" value="${book.name}" required><br>

    <label for="categoryId">Thể loại:</label>
    <select id="categoryId" name="categoryId" required>
        <c:forEach var="categoryId" items="${categories}">
            <option value="${categoryId.id}" ${categoryId.id == book.categoryId.id ? 'selected' : ''}>
                    ${categoryId.name}
            </option>
        </c:forEach>
    </select><br>
    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" value="${book.price}" step="0.01" required><br>

    <label for="stock">Số lượng:</label>
    <input type="number" id="stock" name="stock" value="${book.stock}" required><br>

    <label for="totalPages">Số trang:</label>
    <input type="number" id="totalPages" name="totalPages" value="${book.totalPages}" required><br>

    <label for="yearCreated">Năm xuất bản:</label>
    <input type="number" id="yearCreated" name="yearCreated" value="${book.yearCreated}" required><br>

    <label for="author">Tác giả:</label>
    <input type="text" id="author" name="author" value="${book.author}" required><br>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status" required>
        <option value="true" ${book.status ? 'selected' : ''}>Đang bán</option>
        <option value="false" ${!book.status ? 'selected' : ''}>Ngừng bán</option>
    </select><br>

    <input type="submit" value="UPDATE">
    <a href="books?action=GETALL">Trở về danh sách sách</a>
</form>
</body>
</html>
