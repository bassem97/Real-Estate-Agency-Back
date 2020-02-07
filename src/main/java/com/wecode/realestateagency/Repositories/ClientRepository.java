package com.wecode.realestateagency.Repositories;

import com.wecode.realestateagency.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
    Client findClientByEmail ( String email);
    Client findClientByUsername (String userName);
}