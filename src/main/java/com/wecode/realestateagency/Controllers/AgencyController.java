package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Models.Agency.Agency;
import com.wecode.realestateagency.Services.Agency.AgencyService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Agency/")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping("register" )
    public Agency addAgency(@RequestBody Agency agency){
        return agencyService.addAgency(agency);
    }

    @GetMapping("list")
    public List<Agency> getAllAgencys(){
        return agencyService.getAllAgencys();
    }

    @PutMapping("update/{id}")
    public Agency updateAgency(@Valid @RequestBody Agency agency, @PathVariable("id") long id){
        return agencyService.updateAgency(agency, id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAgency(@PathVariable("id") long id){
        agencyService.deleteAgency(id);
    }

    @GetMapping("agency/{email}")
    public Agency getAgencyByEmail(@PathVariable("email") String email){
        return agencyService.getAgencyByEmail(email);
    }

}
