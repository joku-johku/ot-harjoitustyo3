/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Omistaja
 */
public class Player {
    private String name;
    private String username;
    
    public Player(String name, String username) {
        this.name = name;
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    
    public String getUsername() {
        return username;
    }
     
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        
        Player other = (Player) obj;
        return username.equals(other.username);
    }
}
