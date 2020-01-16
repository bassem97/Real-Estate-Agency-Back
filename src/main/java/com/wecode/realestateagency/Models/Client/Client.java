package com.wecode.realestateagency.Models.Client;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdClient;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;


    @Size(min = 4, message = "Username Length Should Be At Least 4!")
    @Column(unique = true)
    private String username;

    @Size(min = 6, message = "Password Length Should Be At Least 6!")
    private String password;

    @Column(nullable = true)
    private int phoneNumber;

    @Column(unique = true)
    private String email;

    @Column(nullable = true)
    private String birthdate;
    public Client(){
    }

    public Client(String firstName, String lastName, String username, String password, int phoneNumber, String email, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthdate = birthdate;
    }

    public long getId() { return IdClient; }
    public void setId(long id) { IdClient = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public int getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    @Override
    public String toString() {
        return "Client{" +
                "IdClient=" + IdClient +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
