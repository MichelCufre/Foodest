package com.foodest.foodest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.User;

public interface UserRepository extends JpaRepository<User, Long{
    boolean existsByEmail(String email); // Verifica si existe un usuario con el email dado
    User findByEmail(String email);  // Encuentra un usuario por su email
}
