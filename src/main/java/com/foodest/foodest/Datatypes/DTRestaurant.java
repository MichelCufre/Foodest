package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;


public class DTRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
