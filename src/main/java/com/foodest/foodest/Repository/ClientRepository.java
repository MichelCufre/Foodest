package com.foodest.foodest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
