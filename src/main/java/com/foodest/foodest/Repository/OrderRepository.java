package com.foodest.foodest.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.foodest.foodest.Classes.Order;

public interface OrderRepository extends JpaRepository<Order, Long{
}
