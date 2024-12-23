package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DTRestaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private DTRestaurant restaurant;

}
