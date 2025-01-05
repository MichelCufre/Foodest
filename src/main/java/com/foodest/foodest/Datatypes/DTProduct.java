package com.foodest.foodest.Classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DTProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String desc;
    private Double price;
    private String imgUrl;

}
