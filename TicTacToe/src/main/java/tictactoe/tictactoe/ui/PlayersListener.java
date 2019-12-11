/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.tictactoe.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.tictactoe.domain.Logics;

/**
 *
 * @author Omistaja
 */
public class PlayersListener implements ActionListener {
     private Logics logics;
    
    /** Alustaa logiikka-muuttujan.
     * @param logics Pelin logiikka
     */
    public PlayersListener(Logics logics) {
        this.logics = logics;
    }
    
    /** Luo uuden ikkunan tuloksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Players players = new Players(this.logics);
    }
}
