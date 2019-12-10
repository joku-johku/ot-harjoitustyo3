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
public class TicTacToeServicePlayerTest {
  FakePointsDao todoDao;
    FakePlayerDao userDao;
    TicTacToeService service;
    
    @Before
    public void setUp() {
        todoDao = new FakePointsDao();
        userDao = new FakePlayerDao();
        service = new TicTacToeService(todoDao, userDao);     
    }
    
    @Test
    public void nonExistingUserCanLogIn() {
        boolean result = service.login("nonexisting");
        assertFalse(result);
        
        assertEquals(null, service.getLoggedUser());
    }    
    
    @Test
    public void existingUserCanLogIn() {
        boolean result = service.login("Teppo Testaaja");
        assertTrue(result);
        
        Player loggedIn = service.getLoggedUser();
        assertEquals("Teppo Testaaja", loggedIn.getName() );
    }
    
    @Test
    public void loggedInUserCanLogout() {
        service.login("testertester");
        service.logout();
        
        assertEquals(null, service.getLoggedUser());
    }    
    
//    @Test
//    public void userCreationFailsIfNameNotUnique() throws Exception {
//        boolean result = service.createPlayer("Teuvo Testaaja", "Teuvo Testaaja");
//        assertFalse(result);
//    }
    
    @Test
    public void succesfullyCreatedUserCanLogIn() throws Exception {
        boolean result = service.createPlayer("dijkstra", "dijkstra");
        assertTrue(result);
        
        boolean loginOk = service.login("dijkstra");
        assertTrue(loginOk);
        
        Player loggedIn = service.getLoggedUser();
        assertEquals("dijkstra", loggedIn.getName() );
    } 
     @Test
     public void hello() {}
}
