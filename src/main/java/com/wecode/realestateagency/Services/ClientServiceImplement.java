package com.wecode.realestateagency.Services;

import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClients() { return  clientRepository.findAll() ;   }

    @Override
    public Client addClient(Client client) { return clientRepository.saveAndFlush(client); }

    @Override
    public void deleteClient(Long id) { clientRepository.deleteById(id); }

    @Override
    public Client getClientById(Long id) { return clientRepository.findById(id).get(); }

    @Override
    public Client getClientByEmail(String email) { return clientRepository.findClientsByEmail(email); }

    @Override
    public Client updateClient(Client clientDetails, Long id) {
        Client client = clientRepository.findById(id).get();
        client.setBirthdate(clientDetails.getBirthdate());
        client.setEmail(clientDetails.getEmail());
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setUsername(clientDetails.getUsername());
        client.setPassword(clientDetails.getPassword());
        client.setPhoneNumber(clientDetails.getPhoneNumber());
        return clientRepository.saveAndFlush(client);
    }
}
