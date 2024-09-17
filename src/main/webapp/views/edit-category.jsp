<%--
  Created by IntelliJ IDEA.
  User: maixu
  Date: 9/17/2024
  Time: 6:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form method="post" action="/category">--%>
<%--    <div>--%>
<%--        <label for="id">Id</label>--%>
<%--        <input type="text" value="${category.id}" name="id" id="id" readonly>--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label for="name">name</label>--%>
<%--        <input type="text" value="${category.name}" name="name" id="name" >--%>
<%--    </div>--%>
<%--    <div>--%>
<%--        <label for="status">status</label>--%>
<%--        <input type="text" value="${category.status}" name="status" id="status" >--%>
<%--    </div>--%>
<%--<input type="submit" name="action" value="UPDATE">--%>

<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa danh mục</title>
</head>
<body>
<h1>Chỉnh sửa danh mục</h1>

<form action="/category?action=UPDATE" method="post">
    <input type="hidden" name="id" value="${category.id}">

    <label for="name">Tên danh mục:</label>
    <input type="text" id="name" name="name" value="${category.name}" required><br><br>

    <label for="status">Trạng thái:</label>
    <select id="status" name="status">
        <option value="true" ${category.status ? "selected" : ""}>Hoạt động</option>
        <option value="false" ${!category.status ? "selected" : ""}>Không hoạt động</option>
    </select><br><br>
    <input type="submit" value="UPDATE">
</form>


<a href="/category?action=GETALL">Quay lại danh sách</a>
</body>
</html>