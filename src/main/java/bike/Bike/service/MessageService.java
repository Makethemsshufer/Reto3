/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.service;

import bike.Bike.model.Message;
import bike.Bike.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int Message){
        return messageRepository.getMessage(Message);
    }
    
        public Message save(Message message){
        if (message.getId()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> myMessage = messageRepository.getMessage(message.getId());
            
            if (myMessage.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

         public Message update(Message message){
        if(message.getId()!=null){
            Optional<Message> myMessage= messageRepository.getMessage(message.getId());
            if(!myMessage.isEmpty()){
                if(message.getMessageText()!=null){
                    myMessage.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(myMessage.get());
                return myMessage.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
   
        
   public boolean deleteMessage(int id){
        Boolean myMessage = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return myMessage;
    }
        
}
