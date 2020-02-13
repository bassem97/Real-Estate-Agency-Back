package com.wecode.realestateagency.Models;

import com.wecode.realestateagency.Models.User;

import javax.persistence.*;

@Entity
public class Agency extends User {


    @Column(unique = true)
    private String taxRegistration;

    private String agencyName;

    public Agency(){}

    public Agency( String taxRegistration, String agencyName) {
        super();
        this.taxRegistration = taxRegistration;
        this.agencyName = agencyName;
    }

    public String getTaxRegistration() {
        return taxRegistration;
    }

    public void setTaxRegistration(String taxRegistration) {
        this.taxRegistration = taxRegistration;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }


}
