package com.wecode.realestateagency.Repositories;

import com.wecode.realestateagency.Models.Agency.Agency;
import com.wecode.realestateagency.Models.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency,Long> {
    Agency findAgencyByEmail (String email);
}
