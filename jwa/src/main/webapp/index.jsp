<%--
  Created by IntelliJ IDEA.
  User: toddt
  Date: 2025/10/16
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>User Management System</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); height: 100vh; display: flex; justify-content: center; align-items: center; }
        .container { text-align: center; background: white; padding: 50px; border-radius: 10px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); }
        h1 { color: #333; margin-bottom: 30px; }
        .btn { display: inline-block; padding: 12px 30px; margin: 10px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; font-size: 16px; }
        .btn:hover { background: #0056b3; }
        .btn-secondary { background: #6c757d; }
        .btn-secondary:hover { background: #545b62; }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to User Management System</h1>
    <p>Please login or register to continue</p>
    <div>
        <a href="login" class="btn">Login</a>
        <a href="register" class="btn btn-secondary">Register</a>
    </div>
</div>
</body>
</html>
