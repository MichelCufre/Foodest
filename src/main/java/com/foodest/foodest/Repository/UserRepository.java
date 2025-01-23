package com.foodest.foodest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.User;

public interface UserRepository extends JpaRepository<User, Long>{
      // Encuentra un usuario por su email
}
