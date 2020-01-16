package com.wecode.realestateagency.Services;

import com.wecode.realestateagency.Models.Agency.Agency;
import com.wecode.realestateagency.Models.Client.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgencyServices {
    public List<Agency> getAllAgencys();
    public Agency addAgency(Agency agency);
    public Agency updateAgency(Agency agency, Long id);
    public void deleteAgency(Long id);
    public Agency getAgencyById(Long id);
    public Agency getAgencyByEmail(String email);
}
