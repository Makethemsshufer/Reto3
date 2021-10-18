/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.repository;

import bike.Bike.model.Message;
import bike.Bike.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wmg_m
 */

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
    
}
