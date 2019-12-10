/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.swing.JOptionPane;

/**
 * Yksittäisen pelaajan pisteitä kuvaava luokka 
 */

public class Points {
    
    private int id;
    private String points;
    private boolean done;
    private Player player;
    
    public Points(int id, String points, boolean done, Player player) {
        this.id = id;
        this.points = points;
        this.done = false;
        this.player = player;
    }
    
    public Points(String points, Player player) {
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
    
    public boolean isDone() {
        return done;
    }

    public void setDone() {
        done = true;
    }
    
    public void add(Points points) {
        points.add(points);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Points)) {
            return false;
        }
        Points other = (Points) obj;
        return id == other.id;
    }

    
    
}
