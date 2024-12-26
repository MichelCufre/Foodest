package com.foodest.foodest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Product;

public interface ProductRepository extends JpaRepository<Product, Long{
}
