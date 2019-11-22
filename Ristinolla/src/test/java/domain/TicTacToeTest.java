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
        TicTacToe t1 = new TicTacToe(10, null, null);
        TicTacToe t2 = new TicTacToe(10, null, null);
        assertTrue(t1.equals(t2));
    }
  
    @Test
    public void notEqualWhenDifferentId() {
        TicTacToe t1 = new TicTacToe(10, null, null);
        TicTacToe t2 = new TicTacToe(2, null, null);
        assertFalse(t1.equals(t2));
    }   
    
    @Test
    public void nonEqualWhenDifferentType() {
        TicTacToe t = new TicTacToe(10, null, null);
        Object o = new Object();
        assertFalse(t.equals(o));
    }      
}
