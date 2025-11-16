<%--
  Created by IntelliJ IDEA.
  User: toddt
  Date: 2025/10/16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login - User Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>

    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>

    <c:if test="${not empty success}">
        <div class="alert success">${success}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <button type="submit" class="btn">Login</button>
    </form>

    <p>Don't have an account? <a href="${pageContext.request.contextPath}/register">Register here</a></p>
</div>
</body>
</html>