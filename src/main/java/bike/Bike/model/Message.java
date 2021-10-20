
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
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "message")
public class Message implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    
    @Column(nullable = false, length = 250)
    private String messageText;
   
   
    
 
    @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Bike bike;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;
    
    
}
