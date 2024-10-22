package com.wecode.realestateagency.Services.Client;

import com.wecode.realestateagency.Models.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClients();
    public Client addClient(Client client);
    public Client updateClient(Client client, Long id);
    public void deleteClient(Long id);
    public Client getClientById(Long id);
    public Client getClientByEmail(String email);
    public Client getClientByUsername(String username);
}
