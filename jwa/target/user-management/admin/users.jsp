<%--
  Created by IntelliJ IDEA.
  User: toddt
  Date: 2025/11/16
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin - User Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <header>
        <h2>Admin Panel - All Users</h2>
        <div class="user-info">
            <a href="${pageContext.request.contextPath}/profile" class="btn">Back to Profile</a>
            <form action="${pageContext.request.contextPath}/logout" method="post" style="display: inline;">
                <button type="submit" class="btn btn-logout">Logout</button>
            </form>
        </div>
    </header>

    <table class="users-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Role</th>
            <th>Created At</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role}</td>
                <td>${user.createdAt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
