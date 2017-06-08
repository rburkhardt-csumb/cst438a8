<%-- 
    Document   : newuser
    Created on : Jun 7, 2017, 8:50:08 PM
    Author     : Roderick Burkhardt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hangman - Add User</title>
    </head>
    <body>
        <h2>Create User Account</h2>
        
        <form action="newplayer" method="post">
            <input type="hidden" name="action" value="add">
            <label>Username</label>
            <input type="text" name="username"><br />
            <label>First Name:</label>
            <input type="text" name="firstName"><br />
            <label>Last Name:</label>
            <input type="text" name="lastName"><br />
            <label>Password:</label>
            <input type="password" name="verifyPassword"><br />
            <label>Verify Password:</label>
            <input type="password" name="verify"><br />
            <input type="submit" value="Create Account">
        </form>
    </body>
</html>
