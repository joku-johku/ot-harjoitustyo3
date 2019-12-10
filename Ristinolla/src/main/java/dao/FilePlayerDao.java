/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import domain.Player;
/**
 * Pelaajan nimestä vastaava luokka
 */
public class FilePlayerDao implements PlayerDao {
    private List<Player> players;
    private String file;

    public FilePlayerDao(String file) throws Exception {
        players = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                Player u = new Player(parts[0], parts[1]);
                players.add(u);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
        
    }
    
     /**
    * Nimen tallentaminen kirjautuneena olevalle käyttäjälle
    *
    * @param   players   pelaajan nimi
    */
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Player player : players) {
                writer.write(player.getPlayername() + ";" + player.getName() + "\n");
            }
        } 
    }
    
    @Override
    public List<Player> getAll() {
        return players;
    }
    
    @Override
    public Player findByPlayername(String playername) {
        return players.stream()
            .filter(u->u.getPlayername()
            .equals(playername))
            .findFirst()
            .orElse(null);
    }
    
    @Override
    public Player create(Player user) throws Exception {
        players.add(user);
        save();
        return user;
    }    

   
}
