/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.service;

import bike.Bike.model.Bike;
import bike.Bike.repository.BikeRepository;
import bike.Bike.repository.crud.BikeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */

@Service
public class BikeService {
    
    @Autowired
    private BikeRepository bikeRepository;
   
    
    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }
    
    
    public Optional<Bike> getBike(int Bike){
      return bikeRepository.getBike(Bike);
    }
 
  
    
    public Bike save(Bike bike){
        if (bike.getId()==null){
            return bikeRepository.save(bike);
        }else{
            Optional<Bike> myBike = bikeRepository.getBike(bike.getId());
            
            if (myBike.isEmpty()){
                return bikeRepository.save(bike);
            }else{
                return bike;
            }
        }
    }
    
    public Bike update (Bike bike){
        if (bike.getId()!=null){
            Optional<Bike> myBike = bikeRepository.getBike(bike.getId());
            if (!myBike.isEmpty()){
                if (bike.getName()!=null){
                    myBike.get().setName(bike.getName());
                }
                if (bike.getBrand() !=null){
                    myBike.get().setBrand(bike.getBrand());
                }
                if (bike.getYear() !=null){
                    myBike.get().setYear(bike.getYear());
                }
                if (bike.getDescription() !=null){
                    myBike.get().setDescription(bike.getDescription());
                }
                if (bike.getCategory() !=null){
                    myBike.get().setCategory(bike.getCategory());
                }
                bikeRepository.save(myBike.get());
                return  myBike.get();
            }else{
                return bike;
            }
        }else{
            return bike;
        }
    }
    
    public boolean deleteBike(int id){
        Boolean myByke = getBike(id).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return myByke;
    }
    
}
