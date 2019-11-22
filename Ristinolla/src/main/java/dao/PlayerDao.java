/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Player;
import java.util.List;

/**
 *
 * @author Omistaja
 */
public interface PlayerDao {
    
    Player create(Player player) throws Exception;

    Player findByUsername(String username);

    List<Player> getAll();
    
}
