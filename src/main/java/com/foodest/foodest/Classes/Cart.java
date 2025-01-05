package com.foodest.foodest.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {
    @Id
    private String userEmail;

    private Double totalPrice;

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    public Cart() {
    }

    public Cart(String userEmail, Double totalPrice, Client client, List<Product> productList) {
        this.userEmail = userEmail;
        this.totalPrice = totalPrice;
        this.client = client;
        this.productList = productList;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }



    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
