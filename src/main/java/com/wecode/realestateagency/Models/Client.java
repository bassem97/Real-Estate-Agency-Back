package com.wecode.realestateagency.Models;

import com.wecode.realestateagency.Models.User;

import javax.persistence.*;

@Entity
public class Client extends User {



    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;


    @Column(nullable = true)
    private String birthdate;
    public Client(){
    }

    public Client(String firstName, String lastName, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}
