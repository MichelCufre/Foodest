package com.foodest.foodest.Classes;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DTUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String imgUrl;


}
