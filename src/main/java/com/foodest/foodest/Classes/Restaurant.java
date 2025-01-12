package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Restaurant extends User {

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productStock = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String email, String name, String password, String imgUrl, List<Product> productStock) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.imgUrl = imgUrl;
        this.productStock = productStock;

    }

    public List<Product> getProductStock() {
        return productStock;
    }

    public void setProductStock(List<Product> productStock) {
        this.productStock = productStock;
    }
}
