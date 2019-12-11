/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.tictactoe.ui;

import tictactoe.tictactoe.ui.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.tictactoe.domain.Logiikka;

/** ActionListener käyttöliittymän Asetukset-napille.
 */
public class SettingsListener implements ActionListener {
    private Logiikka logiikka;

    
    /** Alustaa logiikka-muuttujan.
     * @param logiikka 
     */
    public SettingsListener(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    /** Luo uuden ikkunan asetuksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Settings asetukset = new Settings(this.logiikka);
    }
}