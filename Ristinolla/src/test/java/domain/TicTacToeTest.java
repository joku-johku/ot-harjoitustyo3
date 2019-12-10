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
public class TicTacToeTest {
    
    public TicTacToeTest() {
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
    public void equalWhenSameId() {
        Points t1 = new Points(10, null, false, null);
        Points t2 = new Points(10, null, false, null);
        assertTrue(t1.equals(t2));
    }
  
    @Test
    public void notEqualWhenDifferentId() {
        Points t1 = new Points(10, null, false, null);
        Points t2 = new Points(2, null, false, null);
        assertFalse(t1.equals(t2));
    }   
    
    @Test
    public void nonEqualWhenDifferentType() {
        Points t = new Points(10, null, false, null);
        Object o = new Object();
        assertFalse(t.equals(o));
    }      
}
