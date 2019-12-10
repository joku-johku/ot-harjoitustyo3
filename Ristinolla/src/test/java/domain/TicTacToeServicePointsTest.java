/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
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
public class TicTacToeServicePointsTest {
    FakePointsDao pointsDao;
    FakePlayerDao playerDao;
    TicTacToeService service;
    
    @Before
    public void setUp() {
        pointsDao = new FakePointsDao();
        playerDao = new FakePlayerDao();
        Player u1 = new Player("Teuvo Testaaja", "Teuvo Testaaja");
        Player u2 = new Player("tester2", "Tellervo Testaaja");
        playerDao.create(u1);
        playerDao.create(u2);        
        pointsDao.create(new Points(1, "23", false, new Player("Teuvo Testaaja", "")));
        service = new TicTacToeService(pointsDao, playerDao);     
        service.login("Teuvo Testaaja");
    }
    
//    @Test
//    public void atStartListContainsInitializedTodos() {
//        List<Points> todos = service.getUndone();
//        
//        assertEquals(1, todos.size());
//        Points todo = todos.get(0);
//        assertEquals("23", todo.getPoints());
//        assertEquals("Teuvo Testaaja", todo.getPlayer().getPlayername());
//    }
     
    @Test
    public void listEmpytIfNotLoggedIn() {
        service.logout();
        List<Points> todos = service.getUndone();
        
        assertEquals(0, todos.size());
    }    
    
//    @Test
//    public void loggedUsersListContainsAddedTodo() {
//        addPoints("imuroi");
//        
//        List<Points> todos = service.getUndone();               
//        assertEquals(2, todos.size());
//        Points todo = todos.get(1);
//        
//        assertEquals("imuroi", todo.getPoints());
//        assertEquals("Teuvo Testaaja", todo.getPlayer().getPlayername());
//    }    

    @Test
    public void loggedUsersListDoesNotContainTodosOfOther() {
        addPoints("imuroi");
        service.logout();
        service.login("tester2");
        
        List<Points> todos = service.getUndone();
        assertEquals(0, todos.size());
    }      
 
    @Test
    public void whenMarkedDoneIsNotListed() {    
        service.markDone(1);
        
        List<Points> todos = service.getUndone();               
        assertEquals(0, todos.size());
    }      
    
    private void addPoints(String content) {
        service.createPoints(content);
    }
     @Test
     public void hello() {}
}
