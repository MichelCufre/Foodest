package com.foodest.foodest.Classes;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    private String userEmail;
    private List<Product> productList;
    private Boolean totalPrice;

    public Cart() {
    }

    public Cart(String userEmail, Boolean totalPrice, List<Product> productList) {
        this.userEmail = userEmail;
        this.totalPrice = totalPrice;
        this.productList = productList;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Boolean getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Boolean totalPrice) {
        this.totalPrice = totalPrice;
    }
}
