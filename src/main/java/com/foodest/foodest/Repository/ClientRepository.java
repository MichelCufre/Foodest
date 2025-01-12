package com.foodest.foodest.Repository;
import com.foodest.foodest.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    boolean existsByEmail(String email); // Verifica si existe un usuario con el email dado
    User findByEmail(String email);
}
