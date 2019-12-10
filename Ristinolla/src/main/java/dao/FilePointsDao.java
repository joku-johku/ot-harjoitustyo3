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
import domain.Points;
import domain.Player;

/**
 * Pisteiden listauksesta vastaava DAO-luokka
 */
public class FilePointsDao implements PointsDao {
    
    public List<Points> points;
    private String file;
    
    public FilePointsDao(String file, PlayerDao players) throws Exception {
        points = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                int id = Integer.parseInt(parts[0]);
                boolean done = Boolean.parseBoolean(parts[2]);
                Player player = players.getAll().stream().filter(u->u.getPlayername().equals(parts[3])).findFirst().orElse(null); 
                Points points = new Points(id, parts[1], done, player);
                points.add(points);
               
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
         
    /**
    * Pisteiden tallentaminen kirjautuneena olevalle käyttäjälle
    *
    * @param   points   pisteiden määrä
    */
     
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Points points : points) {
                writer.write(points.getId() + ";" + points.getPoints() + ";" 
                        + points.getPlayer().getPlayername() + "\n");
            }
        }
    }    
    
    private int generateId() {
        return points.size() + 1;
    }
    
    @Override
    public List<Points> getAll() {
        return points;
    }

    @Override
    public Points create(Points points) throws Exception {
        points.setId(generateId());
        points.add(points);
        save();
        return points;
    }   
    
    @Override
    public void setDone(int id) throws Exception {
        for (Points t : points) {
            if (t.getId() == id) {
                t.setDone();
            }
        }
        save();
    }  
  
    
}
