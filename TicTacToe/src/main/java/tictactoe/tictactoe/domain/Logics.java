package tictactoe.tictactoe.domain;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Pelin sovelluslogiikka. Käyttöliittymän toiminnot käyttävät tätä toimiakseen.
 */
public class Logics {
    private int board[][];  // Pelilauta
    private int gamesState;  // Peli on käynnissä kun tila on 1, poissa kun tila on 0.
    private Random random;  // Tämän avulla päätetään kumpi aloittaa.
    private int whoseTurn;      // x = 1, o = 2.
    private FileHandler fileHandler; // tiedostonkäsittelijä
    private int crossDrawed; // Määrittää minkänäköinen kuvio ristin vuorolla piirretään.
    private int zeroDrawed; // Määrittää minkänäköinen kuvio nollan vuorolla piirretään.
    private int pointscross;
    private int pointszero;
    private String playerOne;
    private String playerTwo;
    private int turn;
    private JLabel score;
    /**
     * Alustaa tyhjän pelipöydän ja muut muuttujat, sekä luo voittojen
     * laskijan..
     */
    public Logics() {
        this.board = new int[][] {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        this.gamesState = 0;
        this.random = new Random();
        this.whoseTurn = 0;
        this.fileHandler = new FileHandler("points.txt", 
            "wins.txt");
        this.crossDrawed = 1;
        this.zeroDrawed = 1;
    }

    public int getGamesState() {
        return this.gamesState;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public FileHandler getFileHandler() {
        return this.fileHandler;
    }

    public int getWhoseTurn() {
        return this.whoseTurn;
    }

    public int getCrossDrawed() {
        return this.crossDrawed;
    }

    public int getZeroDrawed() {
        return this.zeroDrawed;
    }
    
    public String getPlayerOne() {
        return playerOne;
    }
    
    public String getPlayerTwo() {
        return playerTwo;
    }
    
    public int getPointsCross() {
        return this.pointscross;
    }
    
    public int getPointsZero() {
        return this.pointszero;
    }
    
     /**
     * Palauttaa sen pelaajan nimen, jonka vuoro on.  
     * @return pelaajan nimen, jonka vuoro on.
     */
    
    public String getTurn() {
        if (whoseTurn == 1) {
            return playerOne;
        } else {
            return playerTwo;
        }
    }
     /**
     * Alustetaan pelin tila x:n avulla.
     * @param x Pelin tila x.
     * Lopuksi pelin tila on x.
     */
    public void setGamesState(int x) {
        if (x == 0 || x == 1) {
            this.gamesState = x;
        }
    }

    public void setCrossDrawed(int newDrawning) {
        this.crossDrawed = newDrawning;
    }

    public void setZeroDrawed(int newDrawning) {
        this.zeroDrawed = newDrawning;
    }

    /**
     * Käynnistää uuden pelin nollaamalla ensin taulun, jonka jälkeen arvotaan
     * aloittaja. Lopuksi pelin tila vaihdetaan 1.
     */
    public void startGame() {
        this.reset();
        double satunnainen = random.nextDouble();
        if (satunnainen < 0.5) {
            this.whoseTurn = 1;
        } else {
            this.whoseTurn = 2;
        }
        this.gamesState = 1;
    }

    /**
     * Nollaa taulun.
     */
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = 0;
            }
        }
    }

    /**
     * Sijoittaa pöytään x tai o ja vaihtaa vuoroa.
     *
     * @param who Risti tai nolla
     * @param row Mille riville vuoro pelataan
     * @param col Mille sarakkeelle vuoro pelataan
     */
    public void playTurn(int who, int row, int col) {
        if ((who == 1 || who == 2) && this.gamesState == 1) {
            this.board[row][col] = who;
        }

        if (this.whoseTurn == 1) {
            this.whoseTurn = 2;
        } else if (this.whoseTurn == 2) {
            this.whoseTurn = 1;
        }
        getTurn();
    }

    /**
     * Tarkistaa onko toisella kolme vierekkäin.
     *
     * @param who Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean checkWin(int who) {
        if (this.checkRows(who) || this.checkCols(who) || this.checkCrossing(who)) {
            if (who == 1) {
                try {
                    saveScore(who);
                    pointscross++;
                } catch (Exception ex) {
                    Logger.getLogger(Logics.class.getName()).log(Level.SEVERE, null, ex);
                } 
                try {
                    fileHandler.writeIntoWins(getPlayerOne() + " won!\n");
                } catch (Exception ex) {
                    Logger.getLogger(Logics.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    saveScore(who);
                    pointszero++;
                } catch (Exception ex) {
                    Logger.getLogger(Logics.class.getName()).log(Level.SEVERE, null, ex);
                } 
                try {
                    fileHandler.writeIntoWins(getPlayerTwo() + " won!\n");
                } catch (Exception ex) {
                    Logger.getLogger(Logics.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return true;
        }
        return false;
    }
    
     /**
     * Kysyy pelaajan yksi nimeä, jonka pitää olla vähintään neljä merkkiä pitkä.
     * 
     * 
     */
    
    public void getPlayerOneName() {
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        playerOne = JOptionPane.showInputDialog(frame,
                "Player one name: ",
                "Player name",
                JOptionPane.INFORMATION_MESSAGE);
        if (playerOne.equals("") || playerOne.length() < 4) {
            JOptionPane.showMessageDialog(frame,
                "Player name too short ",
                "Wrong name",
                JOptionPane.INFORMATION_MESSAGE);
            getPlayerOneName();
        }
    }
    
    /**
     * Kysyy pelaajan kaksi nimeä, jonka pitää olla vähintään neljä merkkiä pitkä.
     * 
     * 
     */
     
    public void getPlayerTwoName() {
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        playerTwo = JOptionPane.showInputDialog(frame,
                "Player two name: ",
                "Player name",
                JOptionPane.INFORMATION_MESSAGE);
        if (playerTwo.equals("") || playerTwo.length() < 4) {
            JOptionPane.showMessageDialog(frame,
                "Player name too short ",
                "Wrong name",
                JOptionPane.INFORMATION_MESSAGE);
            getPlayerTwoName();
        }
    }
    
    /**
     * Lukee pisteet tiedostoihin.
     *
     * @param who Risti tai nolla.
     * @throws Exception Jos kukaa ei ole olemassa.
     */

    public void saveScore(int who) throws Exception {
        if (who == 1) {
            int pointscross = fileHandler.readCrossPoints();
            pointscross++;
            int pointszero = fileHandler.readZeroPoints();
            
            fileHandler.writeIntoPoints(pointscross + ":" + pointszero);
        } else {
            int ristinPisteet = fileHandler.readCrossPoints();
            int pointszero = fileHandler.readZeroPoints();
            pointszero++;
            fileHandler.writeIntoPoints(pointscross + ":" + pointszero);
        }
    }

    /**
     * Tarkistaa onko riveillä kolme vierekkäistä samaa merkkiä.
     *
     * @param who Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean checkRows(int who) {
        int neighbours = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == who) {
                    neighbours++;
                }
            }
            if (neighbours == 3) {
                return true;
            } else {
                neighbours = 0;
            }
        }
        return false;
    }

    /**
     * Tarkistaa onko sarakkeissa kolme vierekkäistä samaa merkkiä.
     *
     * @param who Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean checkCols(int who) {
        int neighbours = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == who) {
                    neighbours++;
                }
            }
            if (neighbours == 3) {
                return true;
            } else {
                neighbours = 0;
            }
        }
        return false;
    }

    /**
     * Tarkistaa onko viistoissa kolme vierekkäistä samaa merkkiä.
     *
     * @param who Risti tai nolla
     * @return Palauttaa true tai false
     */
    public boolean checkCrossing(int who) {
        if (board[0][0] == who && board[1][1] == who && board[2][2] == who) {
            return true;
        }

        if (board[0][2] == who && board[1][1] == who && board[2][0] == who) {
            return true;
        }

        return false;
    }

    /**
     * Tarkistaa montako ristiä ja nollaa pöydässä on. Palauttaa tosi jos pöytä
     * on täysi.
     *
     * @return Palauttaa true jos pöytä on täysi
     */
    public boolean isBoardFull() {
        int xando = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 0) {
                    xando++;
                }
            }
        }
        if (xando == 9) {
            try {
                fileHandler.writeIntoWins("Tie!\n");
            } catch (Exception ex) {
                Logger.getLogger(Logics.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
}