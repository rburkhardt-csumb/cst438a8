/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8f.data;

import cst438a8f.game.Word;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Roderick Burkhardt
 */
public class GameDB
{
    public static ArrayList<Word> retrieveWords()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        //String qString = "SELECT w FROM Word w";
        Query q = em.createNamedQuery("Word.retrieveWords", Word.class);
        ArrayList<Word> words;
        try
        {
            words = new ArrayList<>(q.getResultList());
            if (words.isEmpty())
            {
                words = null;
            }
        }
        finally
        {
            em.close();
        }
        return words;
    }
    
    public static String retrieveWord(int ID)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        Query q = em.createNamedQuery("Word.retrieveWord", Word.class);
        q.setParameter("id", ID);
        try {
            Word word = (Word)q.getSingleResult();
            return word.getWord();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
