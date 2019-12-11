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
import tictactoe.tictactoe.ui.DrawCanvas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import tictactoe.tictactoe.domain.Logics;

/** ActionListener käyttöliittymän Uusi peli -napille.
 */
public class NewGameListener implements ActionListener {
    private Logics logiikka;
    private JTextField tekstiKentta;
    private DrawCanvas piirtoalusta;
    private Graphics graphics;
    
    /** Alustaa oliomuuttujat.
     * @param logiikka Pelin logiikka
     * @param tekstiKentta Tekstikenttä
     * @param piirtoalusta DrawCanvas, johon ristit ja nollat piirretään.
     */
    public NewGameListener(Logics logiikka, JTextField tekstiKentta, DrawCanvas piirtoalusta) {
        this.logiikka = logiikka;
        this.tekstiKentta = tekstiKentta;
        this.piirtoalusta = piirtoalusta;
    }
    
    /** Tyhjentää piirretyt ristit ja nollat, aloittaa logiikassa uuden pelin ja kertoo tekstikentässä kuka aloittaa.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.graphics = piirtoalusta.getGraphics();
        this.piirtoalusta.paintComponent(graphics);
        this.logiikka.startGame();
        
        String aloittaja = "";
        if (this.logiikka.getWhoseTurn()== 1) {
            aloittaja = "Risti aloittaa!";
        } else {
            aloittaja = "Nolla aloittaa!";
        }
        this.tekstiKentta.setText("Uusi peli aloitettu. " + aloittaja);
    }
    
}