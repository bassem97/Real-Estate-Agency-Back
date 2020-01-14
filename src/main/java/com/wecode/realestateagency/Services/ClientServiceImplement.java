package com.wecode.realestateagency.Services;

import com.wecode.realestateagency.Models.Client;
import com.wecode.realestateagency.Repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplement implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImplement(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

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
    public void updateClient(Client clientDetails, Long id) {
        Client client = clientRepository.findById(id).get();
        client.setBirthDate(clientDetails.getBirthDate());
        client.setEmail(clientDetails.getEmail());
        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());
        client.setUserName(clientDetails.getUserName());
        client.setPassword(clientDetails.getPassword());
        client.setPhoneNumber(clientDetails.getPhoneNumber());
        clientRepository.saveAndFlush(client);
    }
}
