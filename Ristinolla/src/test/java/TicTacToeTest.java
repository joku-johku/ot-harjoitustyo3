/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;
import javax.swing.JButton;
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
      String one = "X";
     String two = "X";
     String three = "X";
     String playerOne;
     
   

private String calculate(String one, String two, String three){
    return "PlayerOne wins!";
}

    
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
          String one = "X";
     String two = "X";
     String three = "X";
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
    public void XWinsPossibilityOne() {
    assertEquals("PlayerOne wins!", calculate(one,two,three));
    }
}



  
    


     

