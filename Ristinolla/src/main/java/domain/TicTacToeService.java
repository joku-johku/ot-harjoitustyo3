/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import dao.PlayerDao;
import dao.PointsDao;

/**
 * Sovelluslogiikasta vastaava luokka 
 */
public class TicTacToeService {
    
    private PointsDao pointsDao;
    private PlayerDao playerDao;
    private Player loggedIn;
    
    public TicTacToeService(PointsDao pointsDao, PlayerDao playerDao) {
        this.playerDao = playerDao;
        this.pointsDao = pointsDao;
    }
    
    /**
    * sisäänkirjautuminen
    * 
    * @param   playername   käyttäjätunnus
    * 
    * @return true jos käyttäjätunnus on olemassa, muuten false 
    */    
    
    public boolean login(String playername) {
        Player player = playerDao.findByPlayername(playername);
        if (player == null) {
            return false;
        }
        
        loggedIn = player;
        
        return true;
    }
    
     /**
    * Pisteiden lisääminen kirjautuneena olevalle käyttäjälle
    *
    * @param   points   pisteiden määrä
    */
    
    public boolean createPoints(String points) {
        Points todo = new Points(points, loggedIn);
        try {   
            pointsDao.create(todo);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
     /**
    * kirjautuneena oleva käyttäjä
    * 
    * @return kirjautuneena oleva käyttäjä 
    */   
    
    public Player getLoggedUser() {
        return loggedIn;
    }
    
      /**
    * kirjautuneen pelaajan pisteet
    * 
    * @return kirjautuneen pelaajan pisteet
    */
    
    public List<Points> getPoints() {
        if (loggedIn == null) {
            return new ArrayList<>();
        }
          
        return pointsDao.getAll()
            .stream()
            .filter(p-> p.getPlayer().equals(loggedIn))
            .filter(p->!p.isDone())
            .collect(Collectors.toList());
    }
    
     /**
    * uloskirjautuminen
    */  
    
    public void logout() {
        loggedIn = null;  
    }
    
    /**
    * uuden käyttäjän luominen
    * 
    * @param   playername   käyttäjätunnus
    * @param   name   käyttäjän nimi
    * 
    * @return true jos käyttäjätunnus on luotu onnistuneesti, muuten false 
    */ 
    
    public boolean createPlayer(String playername, String name)  {   
        if (playerDao.findByPlayername(playername) != null) {
            return false;
        }
        Player player = new Player(playername, name);
        try {
            playerDao.create(player);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
      /**
    * kirjautuneen käyttäjän tarkastattomat pisteet
    * 
    * @return kirjautuneen käyttäjän tarkastattomat pisteet
    */
    
    public List<Points> getUndone() {
        if (loggedIn == null) {
            return new ArrayList<>();
        }
          
        return pointsDao.getAll()
            .stream()
            .filter(t-> t.getPlayer().equals(loggedIn))
            .filter(t->!t.isDone())
            .collect(Collectors.toList());
    }
    
       /**
    * pisteiden merkitseminen tarkastetuksi
    * 
    * @param   id   tarkastettavaksi merkittävän pisteen tunniste
    */    
    
    public void markDone(int id) {
        try {
            pointsDao.setDone(id);
        } catch (Exception ex) {
        }
    }
    
}
