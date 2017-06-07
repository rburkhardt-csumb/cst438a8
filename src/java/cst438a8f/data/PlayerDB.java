/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8f.data;

import cst438a8f.player.Player;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roderick Burkhardt
 */
public class PlayerDB
{
    public static ArrayList<Player> selectPLayers()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Query q = em.createNamedQuery("Player.selectPlayers", Player.class);
        ArrayList<Player> players;
        try
        {
            players = (ArrayList<Player>)q.getResultList();
            return players;
        }
        catch (NoResultException e)
        {
            return null;
        }
        finally
        {
            em.close();
        }
    }
    public static Player selectPlayer(String username)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Query q = em.createNamedQuery("Player.selectPlayer", Player.class);
        q.setParameter("username", username);
        try
        {
            Player player = (Player)q.getSingleResult();
            return player;
        } 
        catch (NoResultException e)
        {
            return  null;
        }
        finally
        {
            em.close();
        }
    }
    
    public static boolean playerExists(String username)
    {
        Player p = selectPlayer(username);
        return p != null;
    }
}
