/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.tictactoe.ui;

import tictactoe.tictactoe.ui.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.tictactoe.domain.Logics;

/** ActionListener käyttöliittymän Settings-napille.
 */
public class SettingsListener implements ActionListener {
    private Logics logics;

    
    /** Alustaa logiikka-muuttujan.
     * @param logics 
     */
    public SettingsListener(Logics logics) {
        this.logics = logics;
    }
    
    /** Luo uuden ikkunan asetuksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Settings settings = new Settings(this.logics);
    }
}