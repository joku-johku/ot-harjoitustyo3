package tictactoeui;

import java.awt.Color;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import dao.FilePointsDao;
import dao.FilePlayerDao;
import domain.TicTacToeService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omistaja
 */
public class TicTacToe extends javax.swing.JFrame {
 
    private String whoseTurn = "X";
    private String playerOne = "Player One";
    private String playerTwo = "Player Two";
    private int playerOneCount = 0;
    private int playerTwoCount = 0;
    private String playersTurn = "";
    private TicTacToeService tictactoeService;
  
  
    public TicTacToe() {
        initComponents();
        setSize(600, 600);
        setTitle("TicTacToe");
        setLocationRelativeTo(null);
        getPlayerOneName();
        getPlayerTwoName();
    }
    
    public void init() throws Exception {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));
        
        String playerFile = properties.getProperty("playerFile");
        String pointsFile = properties.getProperty("pointsFile");
            
        FilePlayerDao playerDao = new FilePlayerDao(playerFile);
        FilePointsDao pointsDao = new FilePointsDao(pointsFile, playerDao);
        tictactoeService = new TicTacToeService(pointsDao, playerDao);
    }
    
    private void setPlayerName() {
        
        if (whoseTurn.equalsIgnoreCase("X")) {
            playersTurn = playerOne;
        } else {
            playersTurn = playerTwo;
        }
        jLabelscore.setText(playerOne + "'s Score is: " + String.valueOf(playerOneCount) 
            + "   \t" + playersTurn + "'s move  " + playerTwo 
            + "'s Score is: " + String.valueOf(playerTwoCount));
    }
    
    
    
    private void setScore() {  
        jLabelscore.setText(playerOne + "'s Score is: " + String.valueOf(playerOneCount) 
                + "  \t" + playerTwo
                + "'s Score is: " + String.valueOf(playerTwoCount));
    }
    

    private void getPlayerOneName() {
        playerOne = JOptionPane.showInputDialog(this,
                "Player one name: ",
                "Player name",
                JOptionPane.INFORMATION_MESSAGE);
          if (playerOne.equals("") || playerOne.length()<4) {
            JOptionPane.showMessageDialog(this,
                "Player name too short or already in use ",
                "Wrong name",
                JOptionPane.INFORMATION_MESSAGE);
           getPlayerOneName();
        }
//         else if (tictactoeService.createPlayer(playerOne, playerOne) ){
//                JOptionPane.showMessageDialog(this,
//                "New Player created ",
//                "Player name",
//                JOptionPane.INFORMATION_MESSAGE);     
//            }
    }
    
     private void getPlayerTwoName() {
        playerTwo = JOptionPane.showInputDialog(this,
                "Player two name: ",
                "Player name",
                JOptionPane.INFORMATION_MESSAGE);
      
        if (playerOne.equals("") || playerTwo.length()<4) {
            JOptionPane.showMessageDialog(this,
                "Player name too short or already in use ",
                "Wrong name",
                JOptionPane.INFORMATION_MESSAGE);
           getPlayerTwoName();
        }    
    }
    
    private void determineWhoseTurn() {
        if (whoseTurn.equalsIgnoreCase("X")) {
            whoseTurn = "0";
        } else {
            whoseTurn = "X";
        }
    }
    
    private void xWins() {
        JOptionPane.showMessageDialog(this, 
                playerOne + " wins!",
                "Winner",
                JOptionPane.INFORMATION_MESSAGE);
        playerOneCount++;
        resetGame();
       
    }
    
    private void oWins() {
        JOptionPane.showMessageDialog(this, 
                playerTwo + " wins!",
                "Winner",
                JOptionPane.INFORMATION_MESSAGE);
        playerTwoCount++;
        resetGame();
        
    }
    
    private void tieGame() {
        String one = jButton1.getText();
        String two = jButton2.getText();
        String three = jButton3.getText();
        String four = jButton4.getText();
        String five = jButton5.getText();
        String six = jButton6.getText();
        String seven = jButton7.getText();
        String eight = jButton8.getText();
        String nine = jButton9.getText();
        
        if (one != "" && two != "" && three != "" && four != "" 
                && five != "" && six != ""
                && seven != "" && eight != "" && nine != "") {
            JOptionPane.showMessageDialog(this, 
                "It's a tie game!",
                "Tie",
                JOptionPane.INFORMATION_MESSAGE);
            resetGame();
            
        }
    }
    
    private void resetGame() {
        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        
        setScore();
    }
    
    private void determineIfWin() {
        String one = jButton1.getText();
        String two = jButton2.getText();
        String three = jButton3.getText();
        String four = jButton4.getText();
        String five = jButton5.getText();
        String six = jButton6.getText();
        String seven = jButton7.getText();
        String eight = jButton8.getText();
        String nine = jButton9.getText();
        
        if (one == "X" && two == "X" && three == "X") {
            xWins();
        }
        if (four == "X" && five == "X" && six == "X") {
            xWins();
        }
        if (seven == "X" && eight == "X" && nine == "X") {
            xWins();
        }
        if (one == "X" && four == "X" && seven == "X") {
            xWins();
        }
        if (two == "X" && five == "X" && eight == "X") {
            xWins();
        }
        if (three == "X" && six == "X" && nine == "X") {
            xWins();
        }
        if (one == "X" && five == "X" && nine == "X") {
            xWins();
        } 
        if (three == "X" && five == "X" && seven == "X") {
            xWins();
        } 
        if (one == "0" && two == "0" && three == "0") {
            oWins();
        }
        if (four == "0" && five == "0" && six == "0") {
            oWins();
        }
        if (seven == "0" && eight == "0" && nine == "0") {
            oWins();
        }
        if (one == "0" && four == "0" && seven == "0") {
            oWins();
        }
        if (two == "0" && five == "0" && eight == "0") {
            oWins();
        }
        if (three == "0" && six == "0" && nine == "0") {
            oWins();
        }
        if (one == "0" && five == "0" && nine == "0") {
            oWins();
        } 
        if (three == "0" && five == "0" && seven == "0") {
            oWins();
        }     
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelscore = new javax.swing.JLabel();
        jPanelgrid = new javax.swing.JPanel();
        jPanelOne = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabelscore.setText("place holder for score");
        jPanel1.add(jLabelscore, java.awt.BorderLayout.PAGE_END);

        jPanelgrid.setBackground(new java.awt.Color(204, 204, 204));
        jPanelgrid.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jPanelOne.setBackground(new java.awt.Color(255, 255, 255));
        jPanelOne.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanelOne.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanelOne);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanelgrid.add(jPanel9);

        jPanel1.add(jPanelgrid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton2.setForeground(Color.pink);
        } else {
            jButton2.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton2ActionPerformed
    // CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton1.setForeground(Color.pink);
        } else {
            jButton1.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton1ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton3.setForeground(Color.pink);
        } else {
            jButton3.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton3ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton4.setForeground(Color.pink);
        } else {
            jButton4.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton4ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton5.setForeground(Color.pink);
        } else {
            jButton5.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton5ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton6.setForeground(Color.pink);
        } else {
            jButton6.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton6ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton7.setForeground(Color.pink);
        } else {
            jButton7.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton7ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton8.setForeground(Color.pink);
        } else {
            jButton8.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton8ActionPerformed
// CHECKSTYLE IGNORE check FOR NEXT 1 LINES
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setText(whoseTurn);
        if (whoseTurn.equalsIgnoreCase("X")) {
            jButton9.setForeground(Color.pink);
        } else {
            jButton9.setForeground(Color.orange);
        }
        determineWhoseTurn();
        determineIfWin();
        tieGame();
        setPlayerName();
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabelscore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelOne;
    private javax.swing.JPanel jPanelgrid;
    // End of variables declaration//GEN-END:variables
}
