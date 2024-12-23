package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class DTOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String desc;
    private List<com.foodest.foodest.Classes.DTProduct> productList;
    private Double totalPrice;

    @OneToMany
    private com.foodest.foodest.Classes.DTProduct product;

    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
