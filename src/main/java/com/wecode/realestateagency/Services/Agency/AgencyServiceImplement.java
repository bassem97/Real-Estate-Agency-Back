package com.wecode.realestateagency.Services.Agency;

import com.wecode.realestateagency.Models.Agency.Agency;
import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyServiceImplement implements AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;

    @Override
    public List<Agency> getAllAgencys() { return agencyRepository.findAll();}

    @Override
    public Agency addAgency(Agency agency) { return agencyRepository.saveAndFlush(agency);}

    @Override
    public Agency updateAgency(Agency agencyDetails, Long id) {
        if (agencyRepository.findById(id).isPresent()) {
            Agency agency = agencyRepository.findById(id).get();
            agency.setTaxRegistration(agencyDetails.getTaxRegistration());
            agency.setAgencyName(agencyDetails.getAgencyName());
            agency.setEmail(agencyDetails.getEmail());
            agency.setUsername(agencyDetails.getUsername());
            agency.setPassword(agencyDetails.getPassword());
            agency.setPhoneNumber(agencyDetails.getPhoneNumber());
            return agencyRepository.saveAndFlush(agency);
        } else {
            return null;
        }
    }

    @Override
    public void deleteAgency(Long id) { agencyRepository.deleteById(id);}

    @Override
    public Agency getAgencyById(Long id) { return agencyRepository.findById(id).isPresent()? agencyRepository.findById(id).get(): null;}

    @Override
    public Agency getAgencyByEmail(String email) { return agencyRepository.findAgencyByEmail(email); }

    @Override
    public Agency getAgencyByUsername(String userName) { return agencyRepository.findAgencyByUsername(userName);}

    @Override
    public Agency getAgencyByTaxRegistration(String taxRegistration) { return agencyRepository.findAgencyBytaxRegistration(taxRegistration); }
}
