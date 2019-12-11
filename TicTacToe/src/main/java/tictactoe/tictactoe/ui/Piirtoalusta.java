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
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/** Alue mihin peliä pelataan. Piirtää luodessa ruudukun, ja pelattaessa ristit ja nollat.
 */
public class Piirtoalusta extends JPanel {
    
    /** Asettaa alustan taustan väriksi valkoisen.
     */
    public Piirtoalusta() {
        super.setBackground(Color.WHITE);
    }
    
    /** Piirtää pelialustalle ristikon.
     * @param g Grafiikka
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawLine(0, 0, 0, 300);
        g.drawLine(0, 0, 300, 0);
        g.drawLine(100, 0, 100, 300);
        g.drawLine(200, 0, 200, 300);
        g.drawLine(300, 0, 300, 300);
        g.drawLine(0, 100, 300, 100);
        g.drawLine(0, 200, 300, 200);
        g.drawLine(0, 300, 300, 300);
    }
    
    /** Piirtää normaalin ristin haluttuun koordinaattiin piirtoalustassa. Logiikan muuttujan ristinAsetus tulee olla 1,
     *  jotta tällainen risti piirretään.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan y-koordinaatti
     */
    public void piirraNormaaliRisti(int x, int y) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.drawLine(x, y, x + 50, y + 50);
        graphics.drawLine(x + 50, y, x, y + 50);
    }
    
    /** Piirtää latinalaisen ristin haluttuun koordinaattiin piirtoalustassa. Logiikan muuttujan ristinAsetus tulee olla 2,
     *  jotta tällainen risti piirretään.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan y-koordinaatti
     */
    public void piirraLatinalainenRisti(int x, int y) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.BLUE);
        graphics.drawLine(x, y + 10, x + 50, y + 10);
        graphics.drawLine(x + 25, y - 15, x + 25, y + 70);
    }
    
    /** Piirtää normaalin nollan haluttuun koordinaattiin piirtoalustassa. Logiikan muuttujan nollanAsetus tulee olla 1,
     *  jotta tällainen nolla piirretään.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan y-koordinaatti
     */
    public void piirraNormaaliNolla(int x, int y) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.RED);
        graphics.drawOval(x - 12, y - 12, 75, 75);
    }
    
    /** Piirtää hymynaaman haluttuun koordinaattiin piirtoalustassa. Logiikan muuttujan nollanAsetus tulee olla 2,
     *  jotta tällainen "nolla" piirretään.
     * @param x Piirtokohdan x-koordinaatti
     * @param y Piirtokohdan y-koordinaatti
     */
    public void piirraHymynaama(int x, int y) {
        Graphics graphics = this.getGraphics();
        graphics.setColor(Color.RED);
        // Piirtää pään.
        graphics.drawOval(x - 12, y - 12, 75, 75);
        // Piirtää vasemman silmän.
        graphics.drawOval(x + 10, y + 10, 10, 10);
        // Piirtää oikean silmän.
        graphics.drawOval(x + 30, y + 10, 10, 10);
        // Piirtää suun.
        graphics.drawArc(x, y + 15, 50, 30, 180, 180);
    }
}