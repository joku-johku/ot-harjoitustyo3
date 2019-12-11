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
import tictactoe.tictactoe.ui.Piirtoalusta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;
import tictactoe.tictactoe.domain.Logiikka;

/** MouseListener piirtoalustalle.
 */
public class PiirtoalustaKuuntelija implements MouseListener {
    private Logiikka logiikka;
    private Piirtoalusta piirtoalusta;
    private int[][] poyta;
    private JTextField tekstiKentta;
    
    /** Alustaa oliomuuttujat.
     * @param logiikka Pelin logiikka
     * @param piirtoalusta Piirtoalusta, johon ristit ja nollat piirretään
     * @param tekstiKentta Tekstikenttä
     */
    public PiirtoalustaKuuntelija(Logiikka logiikka, Piirtoalusta piirtoalusta, JTextField tekstiKentta) {
        this.logiikka = logiikka;
        this.piirtoalusta = piirtoalusta;
        this.poyta = this.logiikka.getPoyta();
        this.tekstiKentta = tekstiKentta;
    }
    
    /**  Sekavannäköinen metodi, joka tarkistaa mihin kohtaan piirtoalustaa pelaaja klikkaa,
     *   ja suorittaasen mukaan vuoron tiettyyn ruutuun.
     * @param e 
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.logiikka.getPelinTila() == 1) {
            if (e.getX() > 0 && e.getX() < 100 && e.getY() > 0 && e.getY() < 100 && this.poyta[0][0] == 0) {
                vuoro(25, 25, 0, 0);
            } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 0 && e.getY() < 100 && poyta[0][1] == 0) {
                vuoro(125, 25, 0, 1);
            } else if (e.getX() > 100 && e.getX() < 300 && e.getY() > 0 && e.getY() < 100 && poyta[0][2] == 0) {
                vuoro(225, 25, 0, 2);
            } else if (e.getX() > 0 && e.getX() < 100 && e.getY() > 100 && e.getY() < 200 && poyta[1][0] == 0) {
                vuoro(25, 125, 1, 0);
            } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 100 && e.getY() < 200 && poyta[1][1] == 0) {
                vuoro(125, 125, 1, 1);
            } else if (e.getX() > 200 && e.getX() < 300 && e.getY() > 100 && e.getY() < 200 && poyta[1][2] == 0) {
                vuoro(225, 125, 1, 2);
            } else if (e.getX() > 0 && e.getX() < 100 && e.getY() > 200 && e.getY() < 300 && poyta[2][0] == 0) {
                vuoro(25, 225, 2, 0);
            } else if (e.getX() > 100 && e.getX() < 200 && e.getY() > 200 && e.getY() < 300 && poyta[2][1] == 0) {
                vuoro(125, 225, 2, 1);
            } else if (e.getX() > 200 && e.getX() < 300 && e.getY() > 2 && e.getY() < 300 && poyta[2][2] == 0) {
                vuoro(225, 225, 2, 2);
            }
        }
    }
    
    /**  Suorittaa vuoron pelin logiikassa, jonka jälkeen piirtoalustaan piirretään joko risti tai nolla.
     *   Lopuksi tarkistetaan loppuuko peli.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan Y-koordinaatti
     * @param rivi Pelipöydän rivi johon vuoro pelataan
     * @param sarake Pelipöydän sarake johon vuoro pelataan
     */
    public void vuoro(int x, int y, int rivi, int sarake) {
        if (this.logiikka.getVuoro() == 1) {
            this.logiikka.suoritaVuoro(1, rivi, sarake);
            if (this.logiikka.getRistinAsetus() == 1) {
                this.piirtoalusta.piirraNormaaliRisti(x, y);
            } else {
                this.piirtoalusta.piirraLatinalainenRisti(x, y);
            }
            
            loppuukoPeli();
        } else {
            this.logiikka.suoritaVuoro(2, rivi, sarake);
            if (this.logiikka.getNollanAsetus() == 1) {
                this.piirtoalusta.piirraNormaaliNolla(x, y);
            } else {
                this.piirtoalusta.piirraHymynaama(x, y);
            }
            
            loppuukoPeli();
        }
    }
    
    /** Jos jompikumpi voittaa, asetetaan pelin tilaksi 0. Tasapelissä sille ei ole tarvetta, sillä ruudukko on jo täynnä.
     */
    public void loppuukoPeli() {
        if (this.logiikka.tarkistaVoitto(1)) {
            this.tekstiKentta.setText("Risti on voittaja!");
            this.logiikka.setPelinTila(0);
        } else if (this.logiikka.tarkistaVoitto(2)) {
            this.tekstiKentta.setText("Nolla on voittaja!");
            this.logiikka.setPelinTila(0);
        } else if (this.logiikka.onkoPoytaTaynna()) {
            this.tekstiKentta.setText("Tasapeli!");
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