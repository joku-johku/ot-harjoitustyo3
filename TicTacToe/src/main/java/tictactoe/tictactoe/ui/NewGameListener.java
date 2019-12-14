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

/** ActionListener käyttöliittymän New game -napille.
 */
public class NewGameListener implements ActionListener {
    private Logics logics;
    private JTextField textField;
    private DrawCanvas canvas;
    private Graphics graphics;
    private Logics playerOne;
    
    /** Alustaa oliomuuttujat.
     * @param logics Pelin logiikka
     * @param textField Tekstikenttä
     * @param canvas DrawCanvas, johon ristit ja nollat piirretään.
     */
    public NewGameListener(Logics logics, JTextField textField, DrawCanvas canvas) {
        this.logics = logics;
        this.textField = textField;
        this.canvas = canvas;
    }
    
    /** Tyhjentää piirretyt ristit ja nollat, aloittaa logiikassa uuden pelin ja kertoo tekstikentässä kuka aloittaa.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.graphics = canvas.getGraphics();
        this.canvas.paintComponent(graphics);
        this.logics.startGame();
        this.logics.getPlayerOneName();
        this.logics.getPlayerTwoName();
        String starter = "";
        if (this.logics.getWhoseTurn() == 1) {
            starter = this.logics.getPlayerOne() + " starts!";
        } else {
            starter = this.logics.getPlayerTwo() + " starts";
        }
        this.textField.setText("New game " + starter);
        
    }
    
}