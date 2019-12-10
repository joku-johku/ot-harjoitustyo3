/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Points;
import java.util.List;


/**
 * Pisteiden rajapinta 
 */
public interface PointsDao {
    
    Points create(Points points) throws Exception;

    List<Points> getAll();

    /**
     *
     * @param id
     * @throws Exception
     */
    void setDone(int id) throws Exception;
    
}
