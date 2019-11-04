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

/**
 *
 * @author Omistaja
 */
public class MaksukorttiTest {
    Maksukortti kortti;
    public MaksukorttiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         kortti = new Maksukortti(100);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}
     
      @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("saldo: 1.0", kortti.toString());
    }
    public void kortilleVoiLadataRahaa() {
    kortti.lataaRahaa(250);
    assertEquals("saldo: 3.50", kortti.toString());
    }
    public void otaRahaa() {
    kortti.lataaRahaa(250);
    kortti.otaRahaa(100);
    assertEquals("saldo: 2.50", kortti.toString());
    }
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi() {
    
    kortti.otaRahaa(300);
    assertEquals("saldo: 1.0", kortti.toString());
    }
     public void ottoPalauttaaTrueJosTarpeeksiRahaa () {
        assertTrue (kortti.otaRahaa(3));
    }
    
     public void ottoPalauttaaFalseJosRiittamatonSaldo () {
        assertTrue (!kortti.otaRahaa(20));
    }
    
    }

