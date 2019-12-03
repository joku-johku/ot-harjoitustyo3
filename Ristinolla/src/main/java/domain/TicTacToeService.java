/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import dao.TicTacToeDao;
import dao.PlayerDao;
import domain.Player;
/**
 *
 * @author Omistaja
 */

/**
 * Sovelluslogiikasta vastaava luokka 
 */
public class TicTacToeService {
    
    private TicTacToeDao ticTacToeDao;
    private PlayerDao playerDao;
    private Player loggedIn;
    
    public TicTacToeService(TicTacToeDao ticTacToeDao, PlayerDao playerDao) {
        this.playerDao = playerDao;
        this.ticTacToeDao = ticTacToeDao;
    }
    
    /**
    * sis‰‰nkirjautuminen
    * 
    * @param   playername   k‰ytt‰j‰tunnus
    * 
    * @return true jos k‰ytt‰j‰tunnus on olemassa, muuten false 
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
    * uloskirjautuminen
    */  
    
    public void logout() {
        loggedIn = null;  
    }
    
    /**
    * uuden k‰ytt‰j‰n luominen
    * 
    * @param   playername   k‰ytt‰j‰tunnus
    * @param   name   k‰ytt‰j‰n nimi
    * 
    * @return true jos k‰ytt‰j‰tunnus on luotu onnistuneesti, muuten false 
    */ 
    
    public boolean createUser(String playername, String name)  {   
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
    
}
