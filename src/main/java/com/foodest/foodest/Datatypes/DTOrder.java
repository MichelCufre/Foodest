package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


public class DTOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String desc;
    private Double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
