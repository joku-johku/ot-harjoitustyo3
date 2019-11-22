/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
    public void equalWhenSamePlayername() {
        Player p1 = new Player("pelaaja1", "Mikko");
        Player p2 = new Player("pelaaja1", "Mikko");
        assertTrue(p1.equals(p2));
    }
    
    @Test
    public void nonEqualWhenDifferentPlayername() {
        Player p1 = new Player("pelaaja1", "Mikko");
        Player p2 = new Player("pelaaja2", "Kalle");
        assertFalse(p1.equals(p2));
    } 
    
    @Test
    public void nonEqualWhenDifferentType() {
        Player u = new Player("pelaaja1", "Mikko");
        Object o = new Object();
        assertFalse(u.equals(o));
    }     
}
