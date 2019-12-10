/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import domain.Player;
import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author Omistaja
 */
public class FilePlayerDaoTest {
    
     @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;  
    PlayerDao dao;
    
    public FilePlayerDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("testfile_users.txt");  
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("Teppo Testaaja;Teppo Testaaja\n");
        }
        
        dao = new FilePlayerDao(userFile.getAbsolutePath());
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {}
    
    @Test
    public void usersAreReadCorrectlyFromFile() {
        List<Player> users = dao.getAll();
        assertEquals(1, users.size());
        Player user = users.get(0);
        assertEquals("Teppo Testaaja", user.getName());
        assertEquals("Teppo Testaaja", user.getPlayername());
    }
    
    @Test
    public void existingUserIsFound() {
        Player user = dao.findByPlayername("Teppo Testaaja");
        assertEquals("Teppo Testaaja", user.getName());
        assertEquals("Teppo Testaaja", user.getPlayername());
    }
    
    @Test
    public void nonExistingUserIsFound() {
        Player user = dao.findByPlayername("hellas");
        assertEquals(user, user);
    }
  
    @Test
    public void savedUserIsFound() throws Exception {
        Player nawUser = new Player("hellas", "hellas");
        dao.create(nawUser);
        
        Player user = dao.findByPlayername("hellas");
        assertEquals("hellas", user.getName());
        assertEquals("hellas", user.getPlayername());
    }
    
      @After
    public void tearDown() {
        userFile.delete();
    }
}
