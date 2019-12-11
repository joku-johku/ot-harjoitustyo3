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
import tictactoe.tictactoe.ui.TuloksetKuuntelija;
import tictactoe.tictactoe.ui.SettingsListener;
import tictactoe.tictactoe.ui.PiirtoalustaKuuntelija;
import tictactoe.tictactoe.ui.Piirtoalusta;
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
import tictactoe.tictactoe.ui.UusiPeliKuuntelija;
import tictactoe.tictactoe.domain.Logiikka;

/** Sovelluksen pääikkuna. Käyttöliittymä koostuu kahdesta osasta: piirtoalustasta ja menusta.
 *  Menuun kuuluu tekstikenttä ja painikkeet.
 */
public class Ui implements Runnable {
    private JFrame frame;
    private Logiikka logiikka;
    
    /** Alustaa logiikka-muuttujan.
     */
    public Ui() {
        this.logiikka = new Logiikka();
    }
    
    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(620, 340));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    /** Asettaa GridLayoutin. Luo piirtoalustan ja menun, jotka lisätään containeriin.
     * @param container 
     */
    public void luoKomponentit(Container container){
        container.setLayout(new GridLayout(1, 2));
        
        JTextField tekstiKentta = new JTextField("Tervetuloa Ristinollaan!");
        tekstiKentta.setEditable(false);
        Piirtoalusta piirtoalusta = new Piirtoalusta();
        piirtoalusta.addMouseListener(new PiirtoalustaKuuntelija(this.logiikka, piirtoalusta, tekstiKentta));
        
        container.add(piirtoalusta);
        container.add(luoMenu(tekstiKentta, piirtoalusta));
    }
    
    /**  
     * Luo oikean puolen käyttöliittymästä. Menu sisältää tekstikentän, sekä napit uudelle pelille ja
     *   pelin lopettamiselle. Tätä metodia kutsutaan luoKomponentit-metodissa. 
     * @param tekstiKentta Käyttöliittymän tekstikenttä
     * @param piirtoalusta Piirtoalusta täytyy antaa uuden pelin kuuntelijalle
     * @return Palauttaa panelin
     */
    public JPanel luoMenu(JTextField tekstiKentta, Piirtoalusta piirtoalusta) {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        
        JButton uusiPeli = new JButton("Uusi peli");
        JButton tulokset = new JButton("Tulokset");
        JButton asetukset = new JButton("Asetukset");
        JButton lopeta = new JButton("Lopeta");
        
        uusiPeli.addActionListener(new UusiPeliKuuntelija(this.logiikka, tekstiKentta, piirtoalusta));
        tulokset.addActionListener(new TuloksetKuuntelija(this.logiikka));
        asetukset.addActionListener(new SettingsListener(this.logiikka));
        lopeta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        panel.add(tekstiKentta);
        panel.add(uusiPeli);
        panel.add(tulokset);
        panel.add(asetukset);
        panel.add(lopeta);
        
        return panel;
    }
}