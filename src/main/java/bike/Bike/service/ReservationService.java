/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.service;

import bike.Bike.model.Reservation;
import bike.Bike.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId){
        return reservationRepository.getReservation(reservationId);
    }
    
        public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()== null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> myReservation = reservationRepository.getReservation(reservation.getIdReservation());

            if (myReservation.isEmpty()){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> myReservation= reservationRepository.getReservation(reservation.getIdReservation());
            if(!myReservation.isEmpty()){

                if(reservation.getStartDate()!=null){
                    myReservation.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    myReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    myReservation.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(myReservation.get());
                return myReservation.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
        
          public boolean deleteReservation(int reservationId){
        Boolean myReservation = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return myReservation;
    }
        
}
