package com.wecode.realestateagency.Services.Client;

import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service(value="clientService")
public class ClientServiceImplement implements ClientService, UserDetailsService {


    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClients() { return  clientRepository.findAll() ;   }

    @Override
    public Client addClient(Client client) { return clientRepository.saveAndFlush(client); }

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
            client.setPassword(clientDetails.getPassword());
            client.setPhoneNumber(clientDetails.getPhoneNumber());
            return clientRepository.saveAndFlush(client);
        }else{ return null;}
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client user = clientRepository.findClientByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }
    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
