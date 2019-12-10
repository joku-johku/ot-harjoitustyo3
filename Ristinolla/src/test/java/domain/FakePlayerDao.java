/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import dao.PlayerDao;
import dao.PlayerDao;
import domain.Player;
//import domain.Player;

/**
 *
 * @author Omistaja
 */
public class FakePlayerDao implements PlayerDao {
    
    List<Player> users = new ArrayList<>();

    public FakePlayerDao() {
        users.add(new Player("Teppo Testaaja", "Teppo Testaaja"));
    }
    
    @Override
    public Player findByPlayername(String username) {
        return users.stream().filter(u->u.getPlayername().equals(username)).findFirst().orElse(null);
    }
    
    @Override
    public Player create(Player user) {
        users.add(user);
        return user;
    } 
    
    @Override
    public List<Player> getAll() {
        return users;
    }

   
}
