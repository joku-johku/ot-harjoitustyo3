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
import tictactoe.tictactoe.domain.TiedostonKasittelija;
import tictactoe.tictactoe.domain.Logiikka;
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
    private TiedostonKasittelija tiedostonKasittelija;

    
    /** Alustaa oliomuuttujat ja avaa uuden ikkunan tuloksille.
     * @param logiikka Pelin logiikka
     */
    public Results(Logiikka logiikka) {
        this.tiedostonKasittelija = logiikka.getTiedostonKasittelija();
        this.frame = new JFrame("Tulokset");
        this.frame.setPreferredSize(new Dimension(340, 340));
        this.frame.setResizable(false);
        this.frame.pack();
        try {
            this.luoKomponentit(frame.getContentPane());
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.setVisible(true);
    }
    
    /** Luo tulos-ikkunan komponentit, niiden kuuntelijat ja lisää ne containeriin.
     * @param container Container, johon komponentit asetetaan.
     */
    private void luoKomponentit(Container container) throws Exception {
        container.setLayout(new GridLayout(3, 1));
        
        final JTextField tekstiKentta = new JTextField("Risti " + tiedostonKasittelija.lueRistinPisteet() + " - " + tiedostonKasittelija.lueNollanPisteet() + " Nolla");
        final JTextArea tekstiAlue = new JTextArea();
        final JScrollPane scrollattava = new JScrollPane(tekstiAlue);
        
        tekstiKentta.setEditable(false);
        tekstiAlue.setEditable(false);
        
        String aikaisemmatPelit = "";
        try {
            aikaisemmatPelit = tiedostonKasittelija.lueVoitot();
        } catch (Exception ex) {
            Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
        }
        tekstiAlue.setText(aikaisemmatPelit);
        
        container.add(tekstiKentta);
        container.add(scrollattava);
        container.add(luoNapit(tekstiKentta, tekstiAlue));
    }
    
    /** Luo napit tulos ikkunan napit. Napit on 1 rivin ja 2 sarakkeen GridLayoutissa.
     * @param tekstiKentta Tekstikenttä, jota nollaa-napin kuuntelija tarvitsee.
     * @param tekstiAlue Tekstialue, jota nollaa-napin kuuntelija tarvitsee.
     * @return Palauttaa panelin, joka lisätään luoKomponentit-metodissa containeriin.
     */
    private JPanel luoNapit(JTextField tekstiKentta, JTextArea tekstiAlue) {
        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton nollaa = new JButton("Nollaa");
        luoNollaaKuuntelija(nollaa, tekstiKentta, tekstiAlue);
        
        JButton sulje = new JButton("Sulje");
        sulje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
            } 
        });
        
        panel.add(nollaa);
        panel.add(sulje);
        
        return panel;
    }
    
    /** Luo kuuntelijan nollaa-napille. Ristin ja nollan pisteet nollataan ja viimeksi pelatut pelit poistetaan.
     * @param nollaa Painike, jolle kuuntelija tehdään.
     * @param tekstiKentta Tekstikenttä, jossa näkyy ristin ja nollan pisteet.
     * @param tekstiAlue Tekstialue, jossa näkyy viime pelien voitot.
     */
    private void luoNollaaKuuntelija(JButton nollaa, final JTextField tekstiKentta, final JTextArea tekstiAlue) {
        nollaa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    tiedostonKasittelija.kirjoitaPisteisiin("0:0");
                    tiedostonKasittelija.nollaaViimeisetVoitot();
                    tekstiKentta.setText("Risti " + tiedostonKasittelija.lueRistinPisteet() + " - " + tiedostonKasittelija.lueNollanPisteet() + " Nolla");
                } catch (Exception ex) {
                    Logger.getLogger(Results.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                tekstiAlue.setText("");
            }
        });
    }
}