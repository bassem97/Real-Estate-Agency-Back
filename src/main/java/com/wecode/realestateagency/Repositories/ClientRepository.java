package com.wecode.realestateagency.Repositories;

import com.wecode.realestateagency.Models.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

   // @Query(value = "SELECT * FROM Client  WHERE email = :email", nativeQuery = true)
    Client findClientByEmail ( String email);
    Client findClientByUsername (String userName);
}