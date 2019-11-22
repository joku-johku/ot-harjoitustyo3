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
public class TicTacToe {
    
    private int id;
    private String points;
    private Player player;
    
    public TicTacToe(int id, String points, Player player) {
        this.id = id;
        this.points = points;
        this.player = player;
    }
    
    public TicTacToe(String points, Player player) {
        this.points = points;
        this.player = player;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPoints() {
        return points;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TicTacToe)) {
            return false;
        }
        TicTacToe other = (TicTacToe) obj;
        return id == other.id;
    }
    
}
