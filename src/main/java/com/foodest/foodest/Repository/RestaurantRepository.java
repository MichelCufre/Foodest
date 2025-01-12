package com.foodest.foodest.Repository;
import com.foodest.foodest.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Restaurant;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
    boolean existsByEmail(String email); // Verifica si existe un usuario con el email dado
    Optional<Restaurant> findByEmail(String email);
}
