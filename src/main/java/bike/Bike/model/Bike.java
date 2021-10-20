/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author wmg_m
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bike")
public class Bike  implements Serializable{
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(nullable = false, length = 45)
private String name;

@Column(nullable = false, length = 45)
private String brand;

@Column(nullable = false, length = 4)
private Integer year;

@Column(nullable = false, length = 250)
private String description;




@ManyToOne
@JoinColumn (name = "categoryId")
@JsonIgnoreProperties ("bikes")
private Category category;



@OneToMany (cascade={CascadeType.PERSIST},mappedBy = "bike" )
@JsonIgnoreProperties({"bike, client"})
private List<Message> message;

@OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "bike")
@JsonIgnoreProperties ({"bike", "client"})
private List<Reservation> reservation;

}