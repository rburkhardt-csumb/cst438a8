/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8f.game;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Roderick Burkhardt
 */
@Entity
@Table(name = "Words")
@NamedQueries({
    @NamedQuery(name = "Word.retrieveWords",
        query = "SELECT w FROM Word w"),
    @NamedQuery(name = "Word.retrieveWord",
        query = "SELECT w FROM Word w WHERE w.id = :id")
})
public class Word implements Serializable
{

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "word")
    private String word;
    

    //private static final long serialVersionUID = 1L;

    public Word()
    {
    }

    public Word(Long id)
    {
        this.id = id;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }

    @Override
    public String toString()
    {
        return word;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Word))
        {
            return false;
        }
        Word other = (Word) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }
    
}
