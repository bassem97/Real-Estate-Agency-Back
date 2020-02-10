package com.wecode.realestateagency.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "local")
public class Local implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdLocal;

    private String type;

    private String description;

    private Float price;

    private String transactionType;

    private int roomsNumber;

    private float area;

    private String address;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnoreProperties(value={"locals","wishList"},allowSetters = true)
    private User user;

    @ManyToMany(mappedBy = "wishList")
    @JsonIgnoreProperties(value = "wishList",allowSetters = true)
    private List<User> userWished = new ArrayList<>();

    public Local(){}
    public Local(String type, String description, Float price, String transcationType, int roomsNumber, float area, String address) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.transactionType = transcationType;
        this.roomsNumber = roomsNumber;
        this.area = area;
        this.address = address;
    }

    public long getIdLocal() {
        return IdLocal;
    }

    public void setIdLocal(long idLocal) {
        IdLocal = idLocal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserWished() {
        return userWished;
    }

    public void setUserWished(List<User> userWished) {
        this.userWished = userWished;
    }

    @Override
    public String toString() {
        return "Local{" +
                "IdLocal=" + IdLocal +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", transactionType='" + transactionType + '\'' +
                ", roomsNumber=" + roomsNumber +
                ", area=" + area +
                ", address='" + address + '\'' +
                '}';
    }
}
