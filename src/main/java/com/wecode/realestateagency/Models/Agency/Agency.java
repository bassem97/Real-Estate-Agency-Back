package com.wecode.realestateagency.Models.Agency;

import com.wecode.realestateagency.Models.User;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Agency extends User {


    @Column(unique = true)
    private String taxRegistration;

    private String agencyName;



    private int phoneNumber;



    public Agency(){}

    public Agency( String taxRegistration, String agencyName, int phoneNumber) {
        super();
        this.taxRegistration = taxRegistration;
        this.agencyName = agencyName;
        this.phoneNumber = phoneNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
