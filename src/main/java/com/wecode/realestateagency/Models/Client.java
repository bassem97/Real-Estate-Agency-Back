package com.wecode.realestateagency.Models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdClient;
    private String firstName;
    private String lastName;
    @Size(min = 4, message = "Username Length Should Be At Least 4!")
    private String userName;
    @Size(min = 6, message = "Password Length Should Be At Least 6!")
    private String password;
    private int phoneNumber;
    @Column(unique = true)
    private String email;
    private String birthDate;
    public Client(){
    }

    public Client(String firstName, String lastName,String userName, String password, int phoneNumber, String email,String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthDate= birthDate;
    }

    public long getId() { return IdClient; }
    public void setId(long id) { IdClient = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    @Override
    public String toString() {
        return "Client{" +
                "IdClient=" + IdClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
