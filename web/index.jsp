<%-- 
    Document   : index
    Created on : May 29, 2017, 5:42:42 AM
    Author     : Roderick Burkhardt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Hangman</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>the Hangman Game</h1>
        <h1>${message}</h1>
        <c:choose>
            <c:when test="${player == null}">
                <h3>Welcome to the game.</h3>
                <p>Would you like to sign-in and play?</p>
                <form action="login" method="get">
                    <input type="hidden" name="action" value="login">
                    <label>Username:</label>
                    <input type="text" name="username"><br />
                    <input type="submit" value="Login">
                </form>
                <h2>Don't have a profile?</h2>
                Setup a profile here
            </c:when>
            <c:otherwise>
                <h3>Hello, ${player.firstName}</h3>
                <h4>Are you ready to play?</h4>
                <form action="game" method="get">
                    <!--input type="hidden" name="action" value="new"-->
                    <input type="submit" value="Play">
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
