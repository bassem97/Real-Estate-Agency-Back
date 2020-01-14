package com.wecode.realestateagency.Services;

import com.wecode.realestateagency.Models.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClients();
    public Client addClient(Client client);
    public void updateClient(Client client, Long id);
    public void deleteClient(Long id);
    public Client getClientById(Long id);
    public Client getClientByEmail(String email);
}
