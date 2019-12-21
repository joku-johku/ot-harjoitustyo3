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

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import tictactoe.tictactoe.domain.Logics;

/** Sovelluksen pääikkuna. Käyttöliittymä koostuu kahdesta osasta: piirtoalustasta, tekstikentästä ja napeista.
 *  
 */
public class Ui implements Runnable {
    private JFrame frame;
    private Logics logics;
    Logics pointscross;
    Logics pointzero;
    
    /** Alustaa logiikka-muuttujan.
     */
    public Ui() {
        this.logics = new Logics();
         
    }
    
    
    
    @Override
    public void run() {
        frame = new JFrame("TicTacToe");
        frame.setPreferredSize(new Dimension(700, 500));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
    
    /** Asettaa GridLayoutin. Luo piirtoalustan ja menun, jotka lisätään containeriin.
     * @param container 
     */
    public void createComponents(Container container) {
        container.setLayout(new GridLayout(1, 2));
        
        JTextField textField = new JTextField("Welcome!");
       
        textField.setEditable(false);
        DrawCanvas canvas = new DrawCanvas();
        canvas.addMouseListener(new DrawCanvasListener(this.logics, canvas, textField));
        
        container.add(canvas);
        container.add(createMenu(textField, canvas));
    }
    
    /**  
     * Luo oikean puolen käyttöliittymästä. Menu sisältää tekstikentän, sekä napit uudelle pelille ja
     *   pelin lopettamiselle. Tätä metodia kutsutaan createComponents-metodissa. 
     * @param textField Käyttöliittymän tekstikenttä
     * @param canvas DrawCanvas täytyy antaa NewGameListener:ille.
     * @return Palauttaa panelin
     */
    public JPanel createMenu(JTextField textField, DrawCanvas canvas) {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JButton newGame = new JButton("New Game");
        JButton settings = new JButton("Settings");
        JButton reset = new JButton("Reset");
        JButton exit = new JButton("Exit");
        newGame.addActionListener(new NewGameListener(this.logics, textField, canvas));
        reset.addActionListener(new ResetListener(logics, textField, canvas));
        settings.addActionListener(new SettingsListener(this.logics));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(textField);
        panel.add(newGame);
        panel.add(settings);
        panel.add(reset);
        panel.add(exit);
       
        return panel;
    }
}