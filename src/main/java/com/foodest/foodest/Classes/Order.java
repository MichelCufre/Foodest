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
    private List<com.foodest.foodest.Classes.DTProduct> productList;
    private Double totalPrice;
    private Boolean status;

    @ManyToOne
    private User user;

    public List<com.foodest.foodest.Classes.DTProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<com.foodest.foodest.Classes.DTProduct> productList) {
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
