/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8f.login;

import cst438a8f.data.PlayerDB;
import cst438a8f.player.Player;
import java.io.IOException;
import static java.rmi.server.LogStream.log;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roderick Burkhardt
 */
public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        
        String url = "/index.jsp";
        
        // get current for index.jsp
        String action = request.getParameter("action");
        if (action == null)
        {
            action = "login";
        }
        
        // perform action and set URL to the appropriate page, request and session values.
        if (action.equals("login"))
        {
            String username = request.getParameter("username");
            Player player;
            //String username = "funplay";//(String) request.getAttribute("username");
            System.out.println("username=" + username);
//            player = new Player();
//            long temp = 1;
//            player.setPlayerId(temp);
//            player.setUsername("funplay");
//            player.setFirstName("database");
//            player.setLastName("play");
            
            //String tempName = player.getUsername();
            if (PlayerDB.playerExists(username))
            //System.out.println(PlayerDB.playerExists(username));
            //if (username.equals(player.getUsername()))
            {        
                player = PlayerDB.selectPlayer(username);
                request.setAttribute("player", player);
                request.setAttribute("message", "player exists");
            }
            else
            {
                String message = "Invalid player, please try again or create user profile." + username;
                request.setAttribute("player", null);
                request.setAttribute("message", message);
            }
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

}
