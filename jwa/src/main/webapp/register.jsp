<%--
  Created by IntelliJ IDEA.
  User: toddt
  Date: 2025/10/16
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register - User Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h2>Register</h2>

    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required
                   pattern="[a-zA-Z0-9_]{3,50}"
                   title="Username must be 3-50 characters, alphanumeric and underscores only">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" id="firstName" name="firstName" required>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required
                   pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$"
                   title="Password must be at least 8 characters with uppercase, lowercase and number">
        </div>

        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>

        <button type="submit" class="btn">Register</button>
    </form>

    <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
</div>
</body>
</html>
