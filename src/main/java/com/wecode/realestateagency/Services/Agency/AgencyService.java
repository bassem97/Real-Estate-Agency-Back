package com.wecode.realestateagency.Services.Agency;

import com.wecode.realestateagency.Models.Agency;

import java.util.List;

public interface AgencyService {
    public List<Agency> getAllAgencys();
    public Agency addAgency(Agency agency);
    public Agency updateAgency(Agency agency, Long id);
    public void deleteAgency(Long id);
    public Agency getAgencyById(Long id);
    public Agency getAgencyByEmail(String email);
    public Agency getAgencyByUsername(String userName);
    public Agency getAgencyByTaxRegistration(String taxRegistration);
}
