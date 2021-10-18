
package bike.Bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 250)
    private String messageText;
   
   
    
 
    @ManyToOne
    @JoinColumn(name="idBike")
    @JsonIgnoreProperties({"message", "client", "reservation"})
    private Bike bike;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"message", "reservation", "client"})
    private Client client;
    
}
