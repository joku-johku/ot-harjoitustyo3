/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.TicTacToe;
import java.util.List;


/**
 *
 * @author Omistaja
 */
public interface TicTacToeDao {
    
    TicTacToe create(TicTacToe todo) throws Exception;

    List<TicTacToe> getAll();

    void setDone(int id) throws Exception;
    
}
