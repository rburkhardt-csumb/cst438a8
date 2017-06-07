/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst438a8f.player;

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
@Table(name = "Players")
@NamedQueries({
    @NamedQuery(name = "Player.selectPlayer",
            query = "SELECT p FROM Player p WHERE p.username = :username"),
    @NamedQuery(name = "Player.selectPlayers",
            query = "SELECT p FROM Player p")
})
public class Player implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "playerId")
    private Long playerId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "password")
    private String password;

    public Player()
    {
    }

    public Player(Long playerId)
    {
        this.playerId = playerId;
    }

    public Player(Long playerId, String username)
    {
        this.playerId = playerId;
        this.username = username;
    }

    public Long getPlayerId()
    {
        return playerId;
    }

    public void setPlayerId(Long playerId)
    {
        this.playerId = playerId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (playerId != null ? playerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player))
        {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "player name " + firstName + " " + lastName;
    }
    
}
