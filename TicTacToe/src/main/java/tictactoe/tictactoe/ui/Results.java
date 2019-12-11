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
import tictactoe.tictactoe.domain.FileHandler;
import tictactoe.tictactoe.domain.Logics;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/** Ikkuna tulosten tarkastelemiseen, sekä nollaamiseen.
 */
public class Results extends JFrame {
    private JFrame frame;
    private FileHandler fileHandler;

    
    /** Alustaa oliomuuttujat ja avaa uuden ikkunan tuloksille.
     * @param logiikka Pelin logiikka
     */
    public Results(Logics logics) {
        this.fileHandler = logics.getFileHandler();
        this.frame = new JFrame("Results");
        this.frame.setPreferredSize(new Dimension(340, 340));
        this.frame.setResizable(false);
        this.frame.pack();
        try {
            this.createComponents(frame.getContentPane());
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.setVisible(true);
    }
    
    /** Luo tulos-ikkunan komponentit, niiden kuuntelijat ja lisää ne containeriin.
     * @param container Container, johon komponentit asetetaan.
     */
    private void createComponents(Container container) throws Exception {
        container.setLayout(new GridLayout(3, 1));
        
        final JTextField textField = new JTextField("Risti " + fileHandler.readCrossPoints()+ " - " + fileHandler.readZeroPoints()+ " Nolla");
        final JTextArea textArea = new JTextArea();
        final JScrollPane scroll = new JScrollPane(textArea);
        
        textField.setEditable(false);
        textArea.setEditable(false);
        
        String earlierGames = "";
        try {
            earlierGames = fileHandler.readWins();
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        textArea.setText(earlierGames);
        
        container.add(textField);
        container.add(scroll);
        container.add(createButtons(textField, textArea));
    }
    
    /** Luo napit tulos ikkunan napit. Napit on 1 rivin ja 2 sarakkeen GridLayoutissa.
     * @param textField Tekstikenttä, jota nollaa-napin kuuntelija tarvitsee.
     * @param textArea Tekstialue, jota nollaa-napin kuuntelija tarvitsee.
     * @return Palauttaa panelin, joka lisätään luoKomponentit-metodissa containeriin.
     */
    private JPanel createButtons(JTextField textField, JTextArea textArea) {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton reset = new JButton("Reset");
        createResetListener(reset, textField, textArea);
        
        JButton close = new JButton("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            } 
        });
        
        panel.add(reset);
        panel.add(close);
        
        return panel;
    }
    
    /** Luo kuuntelijan nollaa-napille. Ristin ja nollan pisteet nollataan ja viimeksi pelatut pelit poistetaan.
     * @param reset Painike, jolle kuuntelija tehdään.
     * @param textField Tekstikenttä, jossa näkyy ristin ja nollan pisteet.
     * @param textArea Tekstialue, jossa näkyy viime pelien voitot.
     */
    private void createResetListener(JButton reset, final JTextField textField, final JTextArea textArea) {
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fileHandler.writeIntoPoints("0:0");
                    fileHandler.resetLatestWins();
                    textField.setText("Cross " + fileHandler.readCrossPoints()+ " - " + fileHandler.readZeroPoints()+ " Zero");
                } catch (Exception ex) {
                    Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                textArea.setText("");
            }
        });
    }
}