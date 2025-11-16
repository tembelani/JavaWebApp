<%--
  Created by IntelliJ IDEA.
  User: toddt
  Date: 2025/10/16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile - User Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h2>User Profile</h2>
        <div class="user-info">
            Welcome, ${user.firstName} ${user.lastName} (${user.role})
            <form action="${pageContext.request.contextPath}/logout" method="post" style="display: inline;">
                <button type="submit" class="btn btn-logout">Logout</button>
            </form>

            <c:if test="${user.role == 'ADMIN'}">
                <a href="${pageContext.request.contextPath}/admin/users" class="btn btn-admin">Admin Panel</a>
            </c:if>
        </div>
    </header>

    <c:if test="${not empty success}">
        <div class="alert success">${success}</div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/profile" method="post">
        <div class="form-section">
            <h3>Basic Information</h3>

            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" value="${user.username}" readonly>
                <small>Username cannot be changed</small>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${user.email}" required>
            </div>

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${user.firstName}" required>
            </div>

            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${user.lastName}" required>
            </div>
        </div>

        <div class="form-section">
            <h3>Profile Details</h3>

            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone"
                       value="${userProfile.phone}"
                       pattern="^[+]?[0-9\\s-()]{10,}$">
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <textarea id="address" name="address">${userProfile.address}</textarea>
            </div>

            <div class="form-group">
                <label for="dateOfBirth">Date of Birth:</label>
                <input type="date" id="dateOfBirth" name="dateOfBirth"
                       value="${userProfile.dateOfBirth}">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">Update Profile</button>
    </form>
</div>
</body>
</html>