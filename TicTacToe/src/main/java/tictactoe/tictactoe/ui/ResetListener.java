
package tictactoe.tictactoe.ui;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import tictactoe.tictactoe.domain.Logics;


public class ResetListener implements ActionListener {
    private Logics logiikka;
    private JTextField tekstiKentta;
    private DrawCanvas piirtoalusta;
    private Graphics graphics;
    
    
    /** Alustaa oliomuuttujat.
     * @param logiikka Pelin logiikka
     * @param tekstiKentta Tekstikenttä
     * @param piirtoalusta DrawCanvas, johon ristit ja nollat piirretään.
     */
    public ResetListener(Logics logiikka, JTextField tekstiKentta, DrawCanvas piirtoalusta) {
        this.logiikka = logiikka;
        this.tekstiKentta = tekstiKentta;
        this.piirtoalusta = piirtoalusta;
       
    }

    
    /** Tyhjentää piirretyt ristit ja nollat, aloittaa logiikassa uuden pelin ja kertoo tekstikentässä kuka aloittaa.
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        this.graphics = piirtoalusta.getGraphics();
        this.piirtoalusta.paintComponent(graphics);
        this.logiikka.startGame();
        this.logiikka.reset();
        String starter = "";
        if (this.logiikka.getWhoseTurn() == 1) {
            starter = this.logiikka.getPlayerOne() + " starts!";
        } else {
            starter = this.logiikka.getPlayerTwo() + " starts";
        }
        this.tekstiKentta.setText("New game started " + starter);
    }
}
