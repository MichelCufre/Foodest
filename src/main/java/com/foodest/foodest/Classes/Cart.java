package com.foodest.foodest.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {
    @Id
    private String email;
    private Double totalPrice;

    @OneToOne(mappedBy = "cart")
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList = new ArrayList<>();

    public Cart() {

    }

    public Cart(Double totalPrice, Client client, List<Product> productList) {
        this.totalPrice = totalPrice;
        this.client = client;
        this.productList = productList;
        email = client.getEmail();
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = userEmail;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
