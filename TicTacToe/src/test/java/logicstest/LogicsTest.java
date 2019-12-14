package logicstest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoe.tictactoe.domain.Logics;

/**
 *
 * @author Omistaja
 */
public class LogicsTest {
    
    Logics logics;
    
    public LogicsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        logics = new Logics();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}
      // Testaa konstruktorin luoman pöydän alkioiden sisällön, sekä muut sen luomat muuttujat.
    @Test
    public void constructorsCreatedByParameters() {
        int poyta[][] = logics.getBoard();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, poyta[i][j]);
            }
        }
        
        assertEquals(0, logics.getGamesState());
        assertEquals(0, logics.getWhoseTurn());
        assertEquals(1, logics.getCrossDrawed());
        assertEquals(1, logics.getZeroDrawed());
    }
    
    // Testaa setGameState-metodin.
    @Test
    public void setGameState() {
        assertEquals(0, logics.getGamesState());
        logics.setGamesState(1);
        assertEquals(1, logics.getGamesState());
    }
    
    // Testaa setCrossDrawed-metodin.
    @Test
    public void setCrossDrawed() {
        assertEquals(1, logics.getCrossDrawed());
        logics.setCrossDrawed(2);
        assertEquals(2, logics.getCrossDrawed());
    }
    
    // Testaa setZeroDrawed-metodin.
    @Test
    public void setZeroDrawed() {
        assertEquals(1, logics.getZeroDrawed());
        logics.setZeroDrawed(2);
        assertEquals(2, logics.getZeroDrawed());
    }
    
    // Testaa täyden pöydän resetoinnin.
    @Test
    public void reset() {
        logics.startGame();
        logics.playTurn(1, 0, 0);
        logics.playTurn(1, 0, 1);
        logics.playTurn(2, 0, 2);
        logics.playTurn(2, 1, 0);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 1, 2);
        logics.playTurn(1, 2, 0);
        logics.playTurn(2, 2, 1);
        logics.playTurn(2, 2, 2);
        int poyta[][] = logics.getBoard();
        
        logics.reset();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, poyta[i][j]);
            }
        }
    }
    
    // Testaa metodin isTableFull.
    @Test
    public void fullTable() {
        logics.startGame();
        logics.playTurn(1, 0, 0);
        logics.playTurn(1, 0, 1);
        logics.playTurn(2, 0, 2);
        logics.playTurn(2, 1, 0);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 1, 2);
        logics.playTurn(1, 2, 0);
        logics.playTurn(2, 2, 1);
        logics.playTurn(2, 2, 2);
        
        assertTrue(logics.isBoardFull());
    }
    
    // Testaa isTableFull false.
    @Test
    public void notFullTable() {
        logics.startGame();
        logics.playTurn(1, 0, 0);
        logics.playTurn(1, 0, 1);
        logics.playTurn(2, 0, 2);
        logics.playTurn(2, 1, 0);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 1, 2);
        logics.playTurn(1, 2, 0);
        logics.playTurn(2, 2, 1);
        assertFalse(logics.isBoardFull());
    }
    
    /* Testaa xxx
     *        ...
     *        ... */
    @Test
    public void firstRowX() {
        logics.startGame();
        logics.playTurn(1, 0, 0);
        logics.playTurn(1, 0, 1);
        logics.playTurn(1, 0, 2);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa ooo
     *        ...
     *        ... */
    @Test
    public void firstRowO() {
        logics.startGame();
        logics.playTurn(2, 0, 0);
        logics.playTurn(2, 0, 1);
        logics.playTurn(2, 0, 2);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa ...
     *        xxx
     *        ... */
    @Test
    public void middleRowX() {
        logics.startGame();
        logics.playTurn(1, 1, 0);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 1, 2);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa ...
     *        ooo
     *        ... */
    @Test
    public void middleRowO() {
        logics.startGame();
        logics.playTurn(2, 1, 0);
        logics.playTurn(2, 1, 1);
        logics.playTurn(2, 1, 2);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa ...
     *        ...
     *        xxx */
    @Test
    public void lastRowX() {
        logics.startGame();
        logics.playTurn(1, 2, 0);
        logics.playTurn(1, 2, 1);
        logics.playTurn(1, 2, 2);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa ...
     *        ...
     *        ooo */
    @Test
    public void lastRowO() {
        logics.startGame();
        logics.playTurn(2, 2, 0);
        logics.playTurn(2, 2, 1);
        logics.playTurn(2, 2, 2);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa x..
     *        x..
     *        x.. */
    @Test
    public void leftColX() {
        logics.startGame();
        logics.playTurn(1, 0, 0);
        logics.playTurn(1, 1, 0);
        logics.playTurn(1, 2, 0);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa o..
     *        o..
     *        o.. */
    @Test
    public void leftColO() {
        logics.startGame();
        logics.playTurn(2, 0, 0);
        logics.playTurn(2, 1, 0);
        logics.playTurn(2, 2, 0);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa .x.
     *        .x.
     *        .x. */
    @Test
    public void middleColX() {
        logics.startGame();
        logics.playTurn(1, 0, 1);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 2, 1);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa .o.
     *        .o.
     *        .o. */
    @Test
    public void middleColO() {
        logics.startGame();
        logics.playTurn(2, 0, 1);
        logics.playTurn(2, 1, 1);
        logics.playTurn(2, 2, 1);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa ..x
     *        ..x
     *        ..x */
    @Test
    public void rightColX() {
        logics.startGame();
        logics.playTurn(1, 0, 2);
        logics.playTurn(1, 1, 2);
        logics.playTurn(1, 2, 2);
        assertTrue(logics.checkWin(1));
  
    }
    /* Testaa ..o
     *        ..o
     *        ..o */
    
    @Test
    public void rightColO() {
        logics.startGame();
        logics.playTurn(2, 0, 2);
        logics.playTurn(2, 1, 2);
        logics.playTurn(2, 2, 2);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa x..
     *        .x.
     *        ..x */
    @Test
    public void diagonalFromLeftToRightX() {
        logics.startGame();
        logics.playTurn(1, 0, 0);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 2, 2);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa o..
     *        .o.
     *        ..o */
    @Test
    public void diagonalFromLeftToRightO() {
        logics.startGame();
        logics.playTurn(2, 0, 0);
        logics.playTurn(2, 1, 1);
        logics.playTurn(2, 2, 2);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa ..x
     *        .x.
     *        x.. */
    @Test
    public void diagonalFromRightToLeftX() {
        logics.startGame();
        logics.playTurn(1, 0, 2);
        logics.playTurn(1, 1, 1);
        logics.playTurn(1, 2, 0);
        assertTrue(logics.checkWin(1));
    }
    
    /* Testaa ..o
     *        .o.
     *        o.. */
    @Test
    public void diagonalFromRightToLeftO() {
        logics.startGame();
        logics.playTurn(2, 0, 2);
        logics.playTurn(2, 1, 1);
        logics.playTurn(2, 2, 0);
        assertTrue(logics.checkWin(2));
    }
    
    /* Testaa ..x
     *        .o.
     *        o..*/
    @Test
    public void diagonalFalse() {
        logics.startGame();
        logics.playTurn(1, 0, 2);
        logics.playTurn(2, 1, 1);
        logics.playTurn(2, 2, 0);
        assertFalse(logics.checkWin(2));
    }
}
