/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.FakePlayerDao;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import domain.Points;
import domain.Player;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;


/**
 *
 * @author Omistaja
 */
public class FilePointsDaoTest {
    
     @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();    
  
    File pointsFile;  
    PointsDao dao;    
    
//     @Before
//    public void setUp() throws Exception {
//        pointsFile = testFolder.newFile("testfile_players.txt");  
//        PlayerDao playerDao = new FakePlayerDao();
//        playerDao.create(new Player("Teppo Testaaja", "Teppo Testaaja"));
//        
//        try (FileWriter file = new FileWriter(pointsFile.getAbsolutePath())) {
//            file.write("1;23;false;Teppo Testaaja\n");
//        }
//        
//        dao = new FilePointsDao(pointsFile.getAbsolutePath(), playerDao);        
//    }
    
//     @Test
//    public void savedPointsIsFound() throws Exception {
//        Points nawPoints = new Points(1,"23",false, new Player("Teppo", "Teppo"));
//        dao.create(nawPoints);
//        
//        Points points = dao.getAll().get(0);
//        assertEquals("Teppo", points.getPlayer());
//        
//    }
   
//    @Test
//    public void todosAreReadCorrectlyFromFile() {
//        List<Points> points = dao.getAll();
//        assertEquals(1, points.size());
////        Points todo = todos.get(0);
////        assertEquals("siivoa", todo.getPoints());
////        assertFalse(todo.isDone());
////        assertEquals(1, todo.getId());
////        assertEquals("testertester", todo.getPlayer().getPlayername());
//    }    
//    
//    @Test
//    public void todosCanBeSetDone() throws Exception {
//        dao.setDone(1);
//        Points todo = dao.getAll().get(1);
//        assertFalse(todo.isDone());
//    }       
//    
//    @Test
//    public void createdTodosAreListed() throws Exception {    
//        dao.create(new Points("lue kokeeseen", new Player("testertester", "")));
//        
//        List<Points> todos = dao.getAll();
//        assertEquals(2, todos.size());
//        Points todo = todos.get(1);
//        assertEquals("lue kokeeseen", todo.getPoints());
//        assertFalse(todo.isDone());
//        assertNotEquals(1, todo.getId());
//        assertEquals("testertester", todo.getPlayer().getPlayername());
//    }     
//    
//    @After
//    public void tearDown() {
//        playerFile.delete();
//    }
}
