/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.enumvalues.PlayerRole;
import cricscorer.repository.generic.GenericInterface;
import java.util.Objects;

/**
 *
 * @author prabin
 */
public class Player implements GenericInterface{

    private Integer id;
    private String name;
    private PlayerRole role;
    private String address;

    public Player() {
    }

    
    public Player(Integer id, String name, PlayerRole role, String address) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.address = address;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public PlayerRole getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(PlayerRole role) {
        this.role = role;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.role);
        hash = 83 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return this.role == other.role;
    }
    
   
}
