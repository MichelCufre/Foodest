package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String desc;
    private List<Product> productList;
    private Double totalPrice;
    private Boolean status;

    @ManyToOne
    private User user;

    public Order() {
    }

    public Order(User user, Boolean status, Double totalPrice, List<Product> productList, String desc, Long id) {
        this.user = user;
        this.status = status;
        this.totalPrice = totalPrice;
        this.productList = productList;
        this.desc = desc;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
