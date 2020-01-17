package com.wecode.realestateagency.Models.Agency;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdAgency;

    @Column(unique = true)
    private String taxRegistration;

    private String agencyName;

    @Size(min = 4, message = "Username Length Should Be At Least 4!")
    @Column(unique = true)
    private String username;

    @Size(min = 6, message = "Password Length Should Be At Least 6!")
    private String password;

    private int phoneNumber;

    @Column(unique = true)
    private String email;

    public Agency(){}

    public Agency(String taxRegistration, String agencyName, @Size(min = 4, message = "Username Length Should Be At Least 4!") String username, @Size(min = 6, message = "Password Length Should Be At Least 6!") String password, int phoneNumber, String email) {
        this.taxRegistration = taxRegistration;
        this.agencyName = agencyName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getIdAgency() {
        return IdAgency;
    }

    public void setIdAgency(long idAgency) {
        IdAgency = idAgency;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "IdAgency=" + IdAgency +
                ", taxRegistration='" + taxRegistration + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
