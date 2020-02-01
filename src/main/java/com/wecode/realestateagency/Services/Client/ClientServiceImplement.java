package com.wecode.realestateagency.Services.Client;

import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<Client> getAllClients() { return  clientRepository.findAll() ;   }

    @Override
    public Client addClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.saveAndFlush(client); }

    @Override
    public void deleteClient(Long id) { clientRepository.deleteById(id); }

    @Override
    public Client getClientById(Long id) { return clientRepository.findById(id).isPresent() ? clientRepository.findById(id).get(): null; }

    @Override
    public Client getClientByEmail(String email) { return clientRepository.findClientByEmail(email); }

    @Override
    public Client getClientByUsername(String username) { return  clientRepository.findClientByUsername(username); }

    //
    @Override
    public Client updateClient(Client clientDetails, Long id) {
        if(clientRepository.findById(id).isPresent()) {
            Client client = clientRepository.findById(id).get();
            client.setBirthdate(clientDetails.getBirthdate());
            client.setEmail(clientDetails.getEmail());
            client.setFirstName(clientDetails.getFirstName());
            client.setLastName(clientDetails.getLastName());
            client.setUsername(clientDetails.getUsername());
            client.setPassword(passwordEncoder.encode(client.getPassword()));
            client.setPhoneNumber(clientDetails.getPhoneNumber());
            return clientRepository.saveAndFlush(client);
        }else{ return null;}
    }
}
