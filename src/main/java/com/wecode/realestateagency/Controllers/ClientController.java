package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Services.Client.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Client/")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("register" )
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @GetMapping("list")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PutMapping("update/{id}")
    public Client updateClient(@Valid @RequestBody Client client, @PathVariable("id") long id){
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteClient(@PathVariable("id") long id){
         clientService.deleteClient(id);
    }

    @GetMapping("client/{email}")
    public Client getClientByEmail(@PathVariable("email") String email){
        return clientService.getClientByEmail(email);
    }


}
