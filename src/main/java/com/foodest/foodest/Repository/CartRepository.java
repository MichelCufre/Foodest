package com.foodest.foodest.Repository;
import com.foodest.foodest.Classes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CartRepository extends JpaRepository<Cart, String>{
    Optional<Cart> findByEmail(String email);
}
