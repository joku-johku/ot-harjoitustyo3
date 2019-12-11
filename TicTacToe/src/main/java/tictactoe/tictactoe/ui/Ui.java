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
import tictactoe.tictactoe.ui.ResultsListener;
import tictactoe.tictactoe.ui.SettingsListener;
import tictactoe.tictactoe.ui.DrawCanvasListener;
import tictactoe.tictactoe.ui.DrawCanvas;
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
import tictactoe.tictactoe.ui.NewGameListener;
import tictactoe.tictactoe.domain.Logics;

/** Sovelluksen pääikkuna. Käyttöliittymä koostuu kahdesta osasta: piirtoalustasta ja menusta.
 *  Menuun kuuluu tekstikenttä ja painikkeet.
 */
public class Ui implements Runnable {
    private JFrame frame;
    private Logics logics;
    
    /** Alustaa logiikka-muuttujan.
     */
    public Ui() {
        this.logics = new Logics();
         
    }
    
    @Override
    public void run() {
        frame = new JFrame("TicTacToe");
        frame.setPreferredSize(new Dimension(620, 340));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
       
        frame.pack();
        frame.setVisible(true);
    }
    
    /** Asettaa GridLayoutin. Luo piirtoalustan ja menun, jotka lisätään containeriin.
     * @param container 
     */
    public void createComponents(Container container) {
        container.setLayout(new GridLayout(1, 2));
        
        JTextField TextField = new JTextField("Welcome!");
        TextField.setEditable(false);
        DrawCanvas canvas = new DrawCanvas();
        canvas.addMouseListener(new DrawCanvasListener(this.logics, canvas, TextField));
        
        container.add(canvas);
        container.add(createMenu(TextField, canvas));
    }
    
    /**  
     * Luo oikean puolen käyttöliittymästä. Menu sisältää tekstikentän, sekä napit uudelle pelille ja
     *   pelin lopettamiselle. Tätä metodia kutsutaan luoKomponentit-metodissa. 
     * @param TextField Käyttöliittymän tekstikenttä
     * @param canvas DrawCanvas täytyy antaa uuden pelin kuuntelijalle
     * @return Palauttaa panelin
     */
    public JPanel createMenu(JTextField TextField, DrawCanvas canvas) {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        JButton newGame = new JButton("New Game");
        JButton players = new JButton("Players");
        JButton results = new JButton("Results");
        JButton settings = new JButton("Settings");
        JButton exit = new JButton("Exit");
        newGame.addActionListener(new NewGameListener(this.logics, TextField, canvas));
        players.addActionListener(new ResultsListener(this.logics));  
        results.addActionListener(new ResultsListener(this.logics));  
        settings.addActionListener(new SettingsListener(this.logics));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(TextField);
        panel.add(newGame);
        panel.add(players);
        panel.add(results);
        panel.add(settings);
        panel.add(exit);
        return panel;
    }
}