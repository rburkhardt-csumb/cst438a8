/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8f.game;

import cst438a8f.data.GameDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roderick Burkhardt
 */
public class GameServlet extends HttpServlet
{
    Game game;// = new Game();
    //protected static Random generator;
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        session.setAttribute("player", session.getAttribute("player"));
        
        
        String url = "/playgame.jsp";
        String message = "";
        Integer messageCode = null;
        
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "new";
        }
        
        if (action.equals("play"))
        {
            String guessString = request.getParameter("guess");
            Integer gameOver = 0;
            if (goodInput(guessString))
            {
                char guessChar = guessString.charAt(0);
                int result = game.playGame(guessChar);
                System.out.println(result);
                switch (result)
                {
                    case 0:
                        message = null;
                        messageCode = null;
                        break;
                    case 1:
                        message = null;
                        messageCode = null;
                        gameOver = 1;
                        break;
                    case 2:
                        message = null;
                        messageCode = 1;
                        break;
                    case 3:
                        message = null;
                        messageCode = 1;
                        gameOver = 1;
                        break;
                }
            }
            else
            {
                message = "Invalid guess, try again!";
                messageCode = 1;
            }
            
            session.setAttribute("gameOver", gameOver);
            session.setAttribute("gameState", game.getState());
            session.setAttribute("gameWord", game.getDisplayWord());
            session.setAttribute("gameMessage", message);
            session.setAttribute("gameMessageCode", messageCode);
        }
        else if (action.equals("new"))
        {
            if (game == null)
            {
                game = new Game();
            }
            game.startNewGame();
            message = "Make your first guess!";
            messageCode = null;
            
            session.setAttribute("gameOver", 0);
            session.setAttribute("gameState", game.getState());
            session.setAttribute("gameWord", game.getDisplayWord());
            session.setAttribute("gameMessage", message);
            session.setAttribute("gameMessageCode", messageCode);
        }
        else if (action.equals("quit"))
        {
            // save score added here
            url = "/index.jsp";
        }
        
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
    
    private boolean goodInput (String guess)
    {
        if ( guess.isEmpty() || guess.length() > 1 )
        {
            return false;
        }
        else
        {
            char userChoice = guess.charAt(0);
            return Character.isLetter(userChoice);
        }
    }

}
