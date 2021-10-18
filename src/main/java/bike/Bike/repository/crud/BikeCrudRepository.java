
package bike.Bike.repository.crud;

import bike.Bike.model.Bike;
import org.springframework.data.repository.CrudRepository;



public interface BikeCrudRepository extends CrudRepository<Bike, Integer>{
    
}
