package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Classes.Restaurant;
import com.foodest.foodest.Repository.RestaurantRepository;
import com.foodest.foodest.Services.ClientService;
import com.foodest.foodest.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/register")
    public ResponseEntity<Restaurant> createRestaurantResponse(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = RestaurantService.registerRestaurant(restaurant.getName(), restaurant.getEmail(), restaurant.getPassword(), restaurant.getImgUrl(),restaurant.getProductStock());
        return ResponseEntity.ok(newRestaurant);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }
}
