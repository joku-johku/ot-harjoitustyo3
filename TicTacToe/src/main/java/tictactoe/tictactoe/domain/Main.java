package tictactoe.tictactoe.domain;

import static javafx.application.Application.launch;
import javax.swing.SwingUtilities;
import tictactoe.tictactoe.ui.Ui;

public class Main { //Main-luokka
    public static void main(String[] args) { //Main-luokka
        Ui kayttoliittyma = new Ui();
        SwingUtilities.invokeLater(kayttoliittyma);
        launch(args);
    }
}