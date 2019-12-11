/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.tictactoe.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import tictactoe.tictactoe.domain.FileHandler;
import tictactoe.tictactoe.domain.Logics;

/**
 *
 * @author Omistaja
 */
public class Players extends JFrame {
  private JFrame frame;
    private Logics logics;
    Players(Logics logics) {
            this.logics = logics;
        this.frame = new JFrame("Players");
        this.frame.setPreferredSize(new Dimension(300, 300));
        this.frame.setResizable(false);
        this.frame.pack();
        this.start(frame.getContentPane());
        this.frame.setVisible(true);
    }
  
  
  
  
public void start(Container ikkuna) {
    TextField vasenTeksti = new TextField();
    TextField oikeaTeksti = new TextField();
    Button nappi = new Button("Kopioi");

    nappi.setOnAction((event) -> {
        oikeaTeksti.setText(vasenTeksti.getText());
    });

    HBox komponenttiryhma = new HBox();
    komponenttiryhma.setSpacing(20);
    komponenttiryhma.getChildren().addAll(vasenTeksti, nappi, oikeaTeksti);

    Scene nakyma = new Scene(komponenttiryhma);

   
}
    
}
