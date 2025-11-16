<%--
  Created by IntelliJ IDEA.
  User: toddt
  Date: 2025/10/16
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h2>Access Denied</h2>
    <p>You don't have permission to access this page.</p>
    <a href="${pageContext.request.contextPath}/profile" class="btn">Back to Profile</a>
</div>
</body>
</html>