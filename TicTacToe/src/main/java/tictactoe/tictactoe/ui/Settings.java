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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import tictactoe.tictactoe.domain.Logics;

/** Ikkuna asetuksien muuttamiseen. 
 */
public class Settings extends JFrame {
    private JFrame frame;
    private Logics logics;
    
    /** Alustaa oliomuuttujat ja tekee uuden ikkunan asetuksille.
     * @param logiikka Pelin logiikka
     */
    public Settings(Logics logics) {
        this.logics = logics;
        this.frame = new JFrame("Settings");
        this.frame.setPreferredSize(new Dimension(300, 300));
        this.frame.setResizable(false);
        this.frame.pack();
        this.createComponents(frame.getContentPane());
        this.frame.setVisible(true);
    }
    
    /** Luo ikkunan komponentit, tekee niille kuuntelijat ja lisää ne containeriin.
     * @param container Container, johon komponentit lisätään.
     */
    private void createComponents(Container container) {
        container.setLayout(new GridLayout(7, 1));
        
        JLabel pickCross = new JLabel("Pick a cross");
        JLabel pickZero = new JLabel("Pick a zero");
        
        ButtonGroup crossGroup = new ButtonGroup();
        ButtonGroup zeroGroup = new ButtonGroup();
        
        JRadioButton cross1 = new JRadioButton("Normal cross");
        JRadioButton cross2 = new JRadioButton("Latin cross");
        JRadioButton zero1 = new JRadioButton("Normal zero");
        JRadioButton zero2 = new JRadioButton("Smiley");
        
        crossGroup.add(cross1);
        crossGroup.add(cross2);
        
        zeroGroup.add(zero1);
        zeroGroup.add(zero2);
        
        JButton close = new JButton("Close");
        
        this.teeKuuntelijat(cross1, cross2, zero1, zero2, close);
        
        container.add(pickCross);
        container.add(cross1);
        container.add(cross2);
        container.add(pickZero);
        container.add(zero1);
        container.add(zero2);
        container.add(close);
    }
    
    /** Tekee komponenteille kuuntelijat.
     * @param cross1 Ensimmäinen asetus ristille.
     * @param cross2 Toinen asetus ristille.
     * @param zero1 Ensimmäinen asetus nollalle.
     * @param zero2 Toinen asetus nollalle.
     * @param close Nappi ikkunan sulkemiselle.
     */
    private void teeKuuntelijat(JRadioButton cross1, JRadioButton cross2, JRadioButton zero1, JRadioButton zero2, JButton close) {
        cross1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logics.setCrossDrawed(1);
            }    
        });
        
        cross2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logics.setCrossDrawed(2);
            }    
        });
        
        zero1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logics.setZeroDrawed(1);
            }    
        });
        
        zero2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logics.setZeroDrawed(2);
            }    
        });
        
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            } 
        });
    }
}
