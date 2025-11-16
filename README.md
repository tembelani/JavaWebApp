JWA (Java Web Application)

This project was built with Servlets, JSP, and MySQL that provides user registration, authentication, profile management and role-based access control.

Features:
- User Registration & Auth (consists of Password Hashing, Login/Logout functionality, session management)
- Profile Management
- Role-Based Access Control
- Security Features

Prerequisites:
Before running the application, one needs to have the following installed:
- JAVA Developmeny Kit (KDK) version 11 or higher.
- Apache Tomcat (version 9.x or higher)
- MySQL Database (version 8.x or higher)
- IntelliJ IDEA
- Maven

👤 User Guide
Registration
Click "Register" on the home page
Fill in required information:
Username (3-50 characters, alphanumeric)
Valid email address
First and last name
Password (min 8 chars, with uppercase, lowercase, and number)
Submit the form

You will be redirected to login page
Login
Enter username and password
Click "Login"

Upon successful authentication, you'll be redirected to your profile
Profile Management
View Profile: Automatically shown after login
Update Profile:
Edit personal information
Add phone number and address
Set date of birth

Click "Update Profile" to save changes
Admin Features
If your account has ADMIN role:
Access Admin Panel from profile page
View all registered users
Monitor user activity

Logout
Click "Logout" button to securely end your session

🔒 Security Features
Implemented Security Measures
Password Security
BCrypt hashing with salt
Strong password requirements
No plain text password storage

🐛 Troubleshooting
Common Issues
Database Connection Error

Verify MySQL service is running
Check database credentials in database.properties
Ensure database and tables exist
Compilation Errors
Clean and rebuild project

Check JDK version compatibility
Verify Maven dependencies
404 Errors
Check Tomcat configuration
Verify application context path
Ensure WAR file is deployed correctly

Session Issues
Clear browser cache and cookies
Check session timeout configuration
Logs and Debugging
Check Tomcat logs in IntelliJ console
Review application logs for specific error messages
Verify database connection in MySQL logs

📞 Support
If you encounter issues:
Check the troubleshooting section above
Verify all prerequisites are installed correctly
Ensure database is properly configured
Check application logs for specific error messages

🛡️ Security Notes
Change default database credentials in production
Use HTTPS in production environment
Regularly update dependencies for security patches
Implement additional security measures for production use


Happy Coding! 🚀




