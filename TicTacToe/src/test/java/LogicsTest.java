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
    public void konstruktorinLuomatMuuttujat() {
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
    
    // Testaa setPelinTila-metodin.
    @Test
    public void setPelinTila() {
        assertEquals(0, logics.getGamesState());
        logics.setGamesState(1);
        assertEquals(1, logics.getGamesState());
    }
    
    // Testaa setRistinAsetus-metodin.
    @Test
    public void setRistinAsetus() {
        assertEquals(1, logics.getCrossDrawed());
        logics.setCrossDrawed(2);
        assertEquals(2, logics.getCrossDrawed());
    }
    
    // Testaa setNollanAsetus-metodin.
    @Test
    public void setNollanAsetus() {
        assertEquals(1, logics.getZeroDrawed());
        logics.setZeroDrawed(2);
        assertEquals(2, logics.getZeroDrawed());
    }
    
    // Testaa täyden pöydän nollauksen.
    @Test
    public void nollaus() {
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
    
    // Testaa metodin onkoPoytaTaynna.
    @Test
    public void taynnaOlevaPoyta() {
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
    
    // Testaa onkoPoytaTaynna false.
    @Test
    public void eiTaynnaOlevaPoyta() {
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
    public void ylaRiviX() {
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
    public void ylaRiviO() {
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
    public void keskiRiviX() {
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
    public void keskiRiviO() {
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
    public void alaRiviX() {
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
    public void alaRiviO() {
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
    public void vasenSarakeX() {
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
    public void vasenSarakeO() {
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
    public void keskiSarakeX() {
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
    public void keskiSarakeO() {
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
    public void oikeaSarakeX() {
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
    public void oikeaSarakeO() {
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
    public void viistoVasemmaltaOikealleX() {
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
    public void viistoVasemmaltaOikealleO() {
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
    public void viistoOikealtaVasemmalleX() {
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
    public void viistoOikealtaVasemmalleO() {
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
    public void viistoFalse() {
        logics.startGame();
        logics.playTurn(1, 0, 2);
        logics.playTurn(2, 1, 1);
        logics.playTurn(2, 2, 0);
        assertFalse(logics.checkWin(2));
    }
}
