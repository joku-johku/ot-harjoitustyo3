
package tictactoe.tictactoe.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoe.tictactoe.domain.Logics;


/** ActionListener käyttöliittymän Tulokset-napille.
 */
public class ResultsListener implements ActionListener {
    private Logics logics;
    
    /** Alustaa logiikka-muuttujan.
     * @param logics Pelin logiikka
     */
    public ResultsListener(Logics logics) {
        this.logics = logics;
    }
    
    /** Luo uuden ikkunan tuloksille.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Results results = new Results(this.logics);
    }
}
