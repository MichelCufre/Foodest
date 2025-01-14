package com.foodest.foodest.Repository;
import com.foodest.foodest.Classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long>{
    boolean existsByEmail(String email); // Verifica si existe un usuario con el email dado
    Optional<Client> findByEmail(String email);
    void deleteByEmail(String email);
}
