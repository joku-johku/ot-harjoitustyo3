package tictactoe.tictactoe.domain;

import static javafx.application.Application.launch;
import javax.swing.SwingUtilities;
import tictactoe.tictactoe.ui.Ui;


public class Main { //Main-luokka
    /**
     * Main luokka.
     * @param args main luokan argumentit.
     * 
     */
    public static void main(String[] args) { 
        Ui ui = new Ui();
        SwingUtilities.invokeLater(ui);
        launch(args);
    }
}