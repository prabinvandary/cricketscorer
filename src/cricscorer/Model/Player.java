/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricscorer.Model;

import cricscorer.enumvalues.PlayerRole;

/**
 *
 * @author prabin
 */
public class Player {

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

    public Integer getId() {
        return id;
    }

    public PlayerRole getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

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
}
