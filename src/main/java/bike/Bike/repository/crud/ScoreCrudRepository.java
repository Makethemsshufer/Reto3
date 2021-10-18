/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.repository.crud;

import bike.Bike.model.Score;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author wmg_m
 */
public interface ScoreCrudRepository  extends CrudRepository<Score, Integer>{
    
}
