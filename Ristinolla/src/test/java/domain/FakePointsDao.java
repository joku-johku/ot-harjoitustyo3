/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dao.PointsDao;
import domain.Points;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Omistaja
 */
public class FakePointsDao implements PointsDao {
    
     List<Points> points;

    public FakePointsDao() {
        points = new ArrayList<>();
    }   
   
    @Override
    public List<Points> getAll() {
        return points;
    }
    
    @Override
    public Points create(Points todo) {
        todo.setId(points.size()+1);
        points.add(todo);
        return todo;
    }   
    
    @Override
    public void setDone(int id) {
        for (Points p : points) {
            if ( p.getId()==id) {
                p.setDone();
            }
        }
    }   

    
}
