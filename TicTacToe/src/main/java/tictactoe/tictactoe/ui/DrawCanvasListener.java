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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;
import tictactoe.tictactoe.domain.Logics;

/** MouseListener piirtoalustalle.
 */
public class DrawCanvasListener implements MouseListener {
    private Logics logics;
    private DrawCanvas canvas;
    private int[][] board;
    private JTextField textField;

    
    /** Alustaa oliomuuttujat.
     * @param logics Pelin logiikka
     * @param canvas DrawCanvas, johon ristit ja nollat piirretään
     * @param textField Tekstikenttä
     */
    public DrawCanvasListener(Logics logics, DrawCanvas canvas, JTextField textField) {
        this.logics = logics;
        this.canvas = canvas;
        this.board = this.logics.getBoard();
        this.textField = textField;
    }
    
    /**  Metodi, joka tarkistaa mihin kohtaan piirtoalustaa pelaaja klikkaa,
     *   ja suorittaa sen mukaan vuoron tiettyyn ruutuun.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.logics.getGamesState() == 1) {
            if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100 && this.board[0][0] == 0) {
                turn(25, 25, 0, 0);
            } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 0 && e.getY() < 100 && board[0][1] == 0) {
                turn(125, 25, 0, 1);
            } else if (e.getX() > 100 && e.getX() < 300 && e.getY() > 0 && e.getY() < 100 && board[0][2] == 0) {
                turn(225, 25, 0, 2);
            } else if (e.getX() > 0 && e.getX() < 100 && e.getY() > 100 && e.getY() < 200 && board[1][0] == 0) {
                turn(25, 125, 1, 0);
            } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 100 && e.getY() < 200 && board[1][1] == 0) {
                turn(125, 125, 1, 1);
            } else if (e.getX() > 200 && e.getX() < 300 && e.getY() > 100 && e.getY() < 200 && board[1][2] == 0) {
                turn(225, 125, 1, 2);
            } else if (e.getX() > 0 && e.getX() < 100 && e.getY() > 200 && e.getY() < 300 && board[2][0] == 0) {
                turn(25, 225, 2, 0);
            } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 200 && e.getY() < 300 && board[2][1] == 0) {
                turn(125, 225, 2, 1);
            } else if (e.getX() > 200 && e.getX() < 300 && e.getY() > 2 && e.getY() < 300 && board[2][2] == 0) {
                turn(225, 225, 2, 2);
            }
        }
    }
    
    /**  Suorittaa vuoron pelin logiikassa, jonka jälkeen piirtoalustaan piirretään joko risti tai nolla.
     *   Lopuksi tarkistetaan loppuuko peli.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan Y-koordinaatti
     * @param row Pelipöydän rivi johon vuoro pelataan
     * @param col Pelipöydän sarake johon vuoro pelataan
     */
    public void turn(int x, int y, int row, int col) {
        if (this.logics.getWhoseTurn() == 1) {
            this.logics.playTurn(1, row, col);
            if (this.logics.getCrossDrawed() == 1) {
                this.canvas.drawNormalCross(x, y);
            } else {
                this.canvas.drawLatinCross(x, y);
            }
            
            hasGameEnded();
        } else {
            this.logics.playTurn(2, row, col);
            if (this.logics.getZeroDrawed() == 1) {
                this.canvas.drawNormalZero(x, y);
            } else {
                this.canvas.drawSmiley(x, y);
            }
            
            hasGameEnded();
        }
    }
    
    /** Jos jompikumpi voittaa, asetetaan pelin tilaksi 0. Tasapelissä sille ei ole tarvetta, sillä ruudukko on jo täynnä.
     */
    public void hasGameEnded() {
        if (this.logics.checkWin(1)) {
            this.textField.setText(logics.getPlayerOne() + " is winner");
            this.logics.setGamesState(0);
        } else if (this.logics.checkWin(2)) {
            this.textField.setText(logics.getPlayerTwo() + " is winner!");
            this.logics.setGamesState(0);
        } else if (this.logics.isBoardFull()) {
            this.textField.setText("It's a tie!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Tätä metodia ei tarvita.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Tätä metodia ei tarvita.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Tätä metodia ei tarvita.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Tätä metodia ei tarvita.
    }
    
}