
package bike.Bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Score {
    
    @Id
    @GeneratedValue(strategy = (GenerationType.IDENTITY))
    private Integer id;
    
    @Column(nullable = false, length = 250)
    private String messageText;
    
    @Column(nullable = false)
    private Integer stars;
   
    @OneToOne
    @JoinColumn(name = "idReservation")
    private Reservation reservation;
}