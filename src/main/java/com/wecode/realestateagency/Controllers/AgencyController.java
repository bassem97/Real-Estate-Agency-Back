package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Models.Agency.Agency;
import com.wecode.realestateagency.Services.Agency.AgencyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/agency/")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping("register" )
    public Agency addAgency(@RequestBody Agency agency){ return agencyService.addAgency(agency); }

    @GetMapping("list")
    public List<Agency> getAllAgencys(){ return agencyService.getAllAgencys(); }

    @PutMapping("update/{id}")
    public Agency updateAgency(@Valid @RequestBody Agency agency, @PathVariable("id") long id){ return agencyService.updateAgency(agency, id); }

    @DeleteMapping("delete/{id}")
    public void deleteAgency(@PathVariable("id") long id){ agencyService.deleteAgency(id); }

    @GetMapping("agencyById/{id}")
    public Agency getAgencyById(@PathVariable("id") Long id){ return agencyService.getAgencyById(id);}

    @GetMapping("agencyByEmail/{email}")
    public Agency getAgencyByEmail(@PathVariable("email") String email){ return agencyService.getAgencyByEmail(email); }

    @GetMapping("agencyByUsername/{username}")
    public Agency getAgencyByUsername(@PathVariable("username") String username){ return agencyService.getAgencyByUsername(username); }

    @GetMapping("agencyByTaxRegistration/{taxRegistration}")
    public Agency getAgencyByTaxRegistration(@PathVariable("taxRegistration") String taxRegistration){ return agencyService.getAgencyByTaxRegistration(taxRegistration); }

}
