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
<form method="post" action="/category?action=ADD">
    <div>
        <label for="name">name</label>
        <input type="text"  name="name" id="name" >
    </div>
    <div>
        <label for="status">status</label>
        <select id="status" name="status" required>
            <option value="true">Hoạt động</option>
            <option value="false">Không hoạt động</option>
        </select><br>
    </div>
    <input type="submit" value="CREATE">

</form>
</body>
</html>
