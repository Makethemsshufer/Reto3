/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bike.Bike.service;

import bike.Bike.model.Client;
import bike.Bike.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wmg_m
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }
    
    public Client save(Client client) {
        if (client.getIdClient()== null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> myClient = clientRepository.getClient(client.getIdClient());
            if (myClient.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    
     public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> myClient= clientRepository.getClient(client.getIdClient());
            if(!myClient.isEmpty()){
                if(client.getName()!=null){
                    myClient.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    myClient.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    myClient.get().setPassword(client.getPassword());
                }
                clientRepository.save(myClient.get());
                return myClient.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
      public boolean deleteClient(int clientId){
        Boolean myClient = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return myClient;
    }
    
}
