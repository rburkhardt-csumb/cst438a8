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
        <c:choose>
            <c:when test="${player == null}">
                <h3>Welcome to the game.</h3>
                <p>Would you like to sign-in and play?</p>
                <c:if test="${message != null}" >
                    <h3>${message}</h3>
                </c:if>
                <form action="login" method="get">
                    <input type="hidden" name="action" value="login">
                    <label>Username:</label>
                    <input type="text" name="username"><span style="font-weight: bold">for testing: funplay</span><br />
                    <input type="submit" value="Login">
                </form>
                <h3>Don't have a profile?</h3>
                Setup a profile <!--a href="/newuser.jsp">here</a-->
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
