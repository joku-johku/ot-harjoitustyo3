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
    private String playername;
    
    public Player(String name, String playername) {
        this.name = name;
        this.playername = playername;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPlayername() {
        return playername;
    }
     
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        
        Player other = (Player) obj;
        return playername.equals(other.playername);
    }
}
