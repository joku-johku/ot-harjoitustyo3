
package tictactoe.tictactoe.ui;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import tictactoe.tictactoe.domain.Logics;

/** ActionListener käyttöliittymän Reset -napille.
 */

public class ResetListener implements ActionListener {
    private Logics logics;
    private JTextField textField;
    private DrawCanvas canvas;
    private Graphics graphics;
    
    
    /** Alustaa oliomuuttujat.
     * @param logics Pelin logiikka
     * @param textField Tekstikenttä
     * @param canvas DrawCanvas, johon ristit ja nollat piirretään.
     */
    public ResetListener(Logics logics, JTextField textField, DrawCanvas canvas) {
        this.logics = logics;
        this.textField = textField;
        this.canvas = canvas;
       
    }

    
    /** Tyhjentää piirretyt ristit ja nollat, aloittaa logiikassa uuden pelin ja kertoo tekstikentässä kuka aloittaa.
     * @param e 
     */
    public void actionPerformed(ActionEvent e) {
        this.graphics = canvas.getGraphics();
        this.canvas.paintComponent(graphics);
        this.logics.startGame();
        this.logics.reset();
        String starter = "";
        if (this.logics.getWhoseTurn() == 1) {
            starter = this.logics.getPlayerOne() + " starts!";
        } else {
            starter = this.logics.getPlayerTwo() + " starts";
        }
        this.textField.setText("New game started " + starter);
    }
}
