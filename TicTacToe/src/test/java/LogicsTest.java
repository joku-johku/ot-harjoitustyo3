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
import tictactoe.tictactoe.domain.Logiikka;

/**
 *
 * @author Omistaja
 */
public class LogicsTest {
    
    Logiikka logiikka;
    
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
        logiikka = new Logiikka();
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
        int poyta[][] = logiikka.getPoyta();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, poyta[i][j]);
            }
        }
        
        assertEquals(0, logiikka.getPelinTila());
        assertEquals(0, logiikka.getVuoro());
        assertEquals(1, logiikka.getRistinAsetus());
        assertEquals(1, logiikka.getNollanAsetus());
    }
    
    // Testaa setPelinTila-metodin.
    @Test
    public void setPelinTila() {
        assertEquals(0, logiikka.getPelinTila());
        logiikka.setPelinTila(1);
        assertEquals(1, logiikka.getPelinTila());
    }
    
    // Testaa setRistinAsetus-metodin.
    @Test
    public void setRistinAsetus() {
        assertEquals(1, logiikka.getRistinAsetus());
        logiikka.setRistinAsetus(2);
        assertEquals(2, logiikka.getRistinAsetus());
    }
    
    // Testaa setNollanAsetus-metodin.
    @Test
    public void setNollanAsetus() {
        assertEquals(1, logiikka.getNollanAsetus());
        logiikka.setNollanAsetus(2);
        assertEquals(2, logiikka.getNollanAsetus());
    }
    
    // Testaa täyden pöydän nollauksen.
    @Test
    public void nollaus() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 1, 2);
        logiikka.suoritaVuoro(1, 2, 0);
        logiikka.suoritaVuoro(2, 2, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        int poyta[][] = logiikka.getPoyta();
        
        logiikka.nollaa();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, poyta[i][j]);
            }
        }
    }
    
    // Testaa metodin onkoPoytaTaynna.
    @Test
    public void taynnaOlevaPoyta() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 1, 2);
        logiikka.suoritaVuoro(1, 2, 0);
        logiikka.suoritaVuoro(2, 2, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        
        assertTrue(logiikka.onkoPoytaTaynna());
    }
    
    // Testaa onkoPoytaTaynna false.
    @Test
    public void eiTaynnaOlevaPoyta() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 1, 2);
        logiikka.suoritaVuoro(1, 2, 0);
        logiikka.suoritaVuoro(2, 2, 1);
        assertFalse(logiikka.onkoPoytaTaynna());
    }
    
    /* Testaa xxx
     *        ...
     *        ... */
    @Test
    public void ylaRiviX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(1, 0, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ooo
     *        ...
     *        ... */
    @Test
    public void ylaRiviO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 0, 1);
        logiikka.suoritaVuoro(2, 0, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ...
     *        xxx
     *        ... */
    @Test
    public void keskiRiviX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 1, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 1, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ...
     *        ooo
     *        ... */
    @Test
    public void keskiRiviO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 1, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ...
     *        ...
     *        xxx */
    @Test
    public void alaRiviX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 2, 0);
        logiikka.suoritaVuoro(1, 2, 1);
        logiikka.suoritaVuoro(1, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ...
     *        ...
     *        ooo */
    @Test
    public void alaRiviO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 2, 0);
        logiikka.suoritaVuoro(2, 2, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa x..
     *        x..
     *        x.. */
    @Test
    public void vasenSarakeX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 1, 0);
        logiikka.suoritaVuoro(1, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa o..
     *        o..
     *        o.. */
    @Test
    public void vasenSarakeO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 1, 0);
        logiikka.suoritaVuoro(2, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa .x.
     *        .x.
     *        .x. */
    @Test
    public void keskiSarakeX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 1);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 2, 1);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa .o.
     *        .o.
     *        .o. */
    @Test
    public void keskiSarakeO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 1);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 1);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ..x
     *        ..x
     *        ..x */
    @Test
    public void oikeaSarakeX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 2);
        logiikka.suoritaVuoro(1, 1, 2);
        logiikka.suoritaVuoro(1, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ..o
     *        ..o
     *        ..o */
    @Test
    public void oikeaSarakeO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 2);
        logiikka.suoritaVuoro(2, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa x..
     *        .x.
     *        ..x */
    @Test
    public void viistoVasemmaltaOikealleX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 0);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa o..
     *        .o.
     *        ..o */
    @Test
    public void viistoVasemmaltaOikealleO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 0);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 2);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ..x
     *        .x.
     *        x.. */
    @Test
    public void viistoOikealtaVasemmalleX() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 2);
        logiikka.suoritaVuoro(1, 1, 1);
        logiikka.suoritaVuoro(1, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(1));
    }
    
    /* Testaa ..o
     *        .o.
     *        o.. */
    @Test
    public void viistoOikealtaVasemmalleO() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(2, 0, 2);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 0);
        assertTrue(logiikka.tarkistaVoitto(2));
    }
    
    /* Testaa ..x
     *        .o.
     *        o..*/
    @Test
    public void viistoFalse() {
        logiikka.aloitaPeli();
        logiikka.suoritaVuoro(1, 0, 2);
        logiikka.suoritaVuoro(2, 1, 1);
        logiikka.suoritaVuoro(2, 2, 0);
        assertFalse(logiikka.tarkistaVoitto(2));
    }
}
