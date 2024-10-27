<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

</html>
<head>
<title> Admin page</title>
</head>
<h3>Add user</h3>
<body>
<form action="${pageContext.request.contextPath}/admin" method="post">
    <label for="login">Login</label><br/>
    <input id="login" type="text" name="login" size="30"> <br/>
    <label for="password">Password</label><br/>
    <input id="password" type="password" name="password" size="30"><br/>
    <input type="submit" value="OK">
</form>
<a href="${pageContext.request.contextPath}/logout">logout</a>
</body>
</html>
