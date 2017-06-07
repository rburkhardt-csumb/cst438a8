<%-- 
    Document   : playgame
    Created on : Jun 2, 2017, 10:56:19 PM
    Author     : rburkhardt
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
        <h2>Hangman</h2>
        <img src="images/h${gameState}.gif">
        <h2 style="font-family:'Lucida Console', monospace">${gameWord}</h2>
        <c:choose>
            <c:when test="${gameMessageCode != null}">
                <h2 style="font-family:'Lucida Console', monospace; color:red;">${gameMessage}</h2>
            </c:when>
            <c:otherwise>
                <h2 style="font-family:'Lucida Console', monospace;">${gameMessage}</h2>
            </c:otherwise>
        </c:choose>
        <form action="game" method="get">
            <label>Guess a character</label>
            <input type="text" name="guess"><br>
            <!--input type="hidden" name="action" value="play">
                    <input type="submit" value="Play"-->
            <c:choose>
                <c:when test="${gameOver == 0}">
                    <input type="hidden" name="action" value="play">
                    <input type="submit" value="Play">
                </c:when>
                <c:otherwise>
                    <input type="hidden" name="action" value="new">
                    <input type="submit" value="New Game">
                </c:otherwise>
            </c:choose>            
            <a href="game?action=quit">Quit</a>
        </form>
    </body>
</html>
