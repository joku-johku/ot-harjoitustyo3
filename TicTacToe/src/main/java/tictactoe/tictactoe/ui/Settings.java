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
import tictactoe.tictactoe.domain.Logiikka;

/** Ikkuna asetuksien muuttamiseen. 
 */
public class Settings extends JFrame {
    private JFrame frame;
    private Logiikka logiikka;
    
    /** Alustaa oliomuuttujat ja tekee uuden ikkunan asetuksille.
     * @param logiikka Pelin logiikka
     */
    public Settings(Logiikka logiikka) {
        this.logiikka = logiikka;
        this.frame = new JFrame("Asetukset");
        this.frame.setPreferredSize(new Dimension(300, 300));
        this.frame.setResizable(false);
        this.frame.pack();
        this.luoKomponentit(frame.getContentPane());
        this.frame.setVisible(true);
    }
    
    /** Luo ikkunan komponentit, tekee niille kuuntelijat ja lisää ne containeriin.
     * @param container Container, johon komponentit lisätään.
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(7, 1));
        
        JLabel valitseRisti = new JLabel("Valitse ristin kuvio");
        JLabel valitseNolla = new JLabel("Valitse nollan kuvio");
        
        ButtonGroup ristinRyhma = new ButtonGroup();
        ButtonGroup nollanRyhma = new ButtonGroup();
        
        JRadioButton risti1 = new JRadioButton("Normaali risti");
        JRadioButton risti2 = new JRadioButton("Latinalainen risti");
        JRadioButton nolla1 = new JRadioButton("Normaali nolla");
        JRadioButton nolla2 = new JRadioButton("Hymynaama");
        
        ristinRyhma.add(risti1);
        ristinRyhma.add(risti2);
        
        nollanRyhma.add(nolla1);
        nollanRyhma.add(nolla2);
        
        JButton sulje = new JButton("Sulje");
        
        this.teeKuuntelijat(risti1, risti2, nolla1, nolla2, sulje);
        
        container.add(valitseRisti);
        container.add(risti1);
        container.add(risti2);
        container.add(valitseNolla);
        container.add(nolla1);
        container.add(nolla2);
        container.add(sulje);
    }
    
    /** Tekee komponenteille kuuntelijat.
     * @param risti1 Ensimmäinen asetus ristille.
     * @param risti2 Toinen asetus ristille.
     * @param nolla1 Ensimmäinen asetus nollalle.
     * @param nolla2 Toinen asetus nollalle.
     * @param sulje Nappi ikkunan sulkemiselle.
     */
    private void teeKuuntelijat(JRadioButton risti1, JRadioButton risti2, JRadioButton nolla1, JRadioButton nolla2, JButton sulje) {
        risti1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logiikka.setRistinAsetus(1);
            }    
        });
        
        risti2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logiikka.setRistinAsetus(2);
            }    
        });
        
        nolla1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logiikka.setNollanAsetus(1);
            }    
        });
        
        nolla2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logiikka.setNollanAsetus(2);
            }    
        });
        
        sulje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            } 
        });
    }
}
