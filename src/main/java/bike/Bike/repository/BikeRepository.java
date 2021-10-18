
package bike.Bike.repository;

import bike.Bike.model.Bike;
import bike.Bike.repository.crud.BikeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BikeRepository {
    
    @Autowired
    private BikeCrudRepository bikeCrudRepository;
    
    public List<Bike> getAll(){
        return (List<Bike>) bikeCrudRepository.findAll();
    }
    
    public Optional<Bike> getBike(int id){
        return bikeCrudRepository.findById(id);
    }
    
    public Bike save(Bike bike){
        return bikeCrudRepository.save(bike);
    }
    
    public void delete(Bike bike){
        bikeCrudRepository.delete(bike);
    }
   
    
}
