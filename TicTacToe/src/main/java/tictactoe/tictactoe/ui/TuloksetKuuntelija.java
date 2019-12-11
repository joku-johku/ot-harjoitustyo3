/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.tictactoe.ui;

/**
 *
 * @author Omistaja
 */
import tictactoe.tictactoe.ui.Results;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.tictactoe.domain.Logiikka;

/** ActionListener käyttöliittymän Tulokset-napille.
 */
public class TuloksetKuuntelija implements ActionListener {
    private Logiikka logiikka;
    
    /** Alustaa logiikka-muuttujan.
     * @param logiikka Pelin logiikka
     */
    public TuloksetKuuntelija(Logiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    /** Luo uuden ikkunan tuloksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Results tulokset = new Results(this.logiikka);
    }
}
