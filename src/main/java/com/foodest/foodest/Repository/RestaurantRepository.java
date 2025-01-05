package com.foodest.foodest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}
