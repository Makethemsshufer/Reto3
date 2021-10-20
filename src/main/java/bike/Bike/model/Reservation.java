
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
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date DevolutionDate;
    private String status="created";
    private String score;
    
    
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties("reservations")
    private Bike bike;
    
     

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
    

    
    //@OneToOne(cascade = (CascadeType.REMOVE),mappedBy ="reservation")
    //@JsonIgnoreProperties("score")
    //private Score score;+
  
 
  
}
