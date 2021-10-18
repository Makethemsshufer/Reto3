
package bike.Bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date startDate;
    private Date DevolutionDate;
    private String status="created";
    //private String score
    
    
    @ManyToOne
    @JoinColumn(name="idBike")
    @JsonIgnoreProperties("reservation")
    private Bike bike;
    
     

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservation","message"})
    private Client client;
    

    
    //@OneToOne(cascade = (CascadeType.REMOVE),mappedBy ="reservation")
    //@JsonIgnoreProperties("score")
    //private Score score;+
    

  
}
