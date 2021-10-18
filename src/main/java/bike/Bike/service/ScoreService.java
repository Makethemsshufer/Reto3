/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.service;

import bike.Bike.model.Score;
import bike.Bike.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    
    public Score save(Score score){
        if (score.getId()==null){
            return scoreRepository.save(score);
        }else{
            Optional<Score> myScore = scoreRepository.getScore(score.getId());
            
            if (myScore.isEmpty()){
                return scoreRepository.save(score);
            }else{
                return score;
            }
        }
    }
    
}
