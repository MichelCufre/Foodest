package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Client;
import com.foodest.foodest.Classes.Product;
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

    @PostMapping("/{email}/add-product")
    public ResponseEntity<String> addProductToRestaurantStock(
            @PathVariable String email,
            @RequestBody Product product) {
        restaurantService.addProductToStock(email, product);
        return ResponseEntity.ok("Product added to restaurant stock successfully!");
    }

    @PostMapping("/{email}/remove-product")
    public ResponseEntity<String> removeProductToRestaurantStock(
            @PathVariable String email,
            @RequestBody Product product) {
        restaurantService.removeProductFromStock(email, product);
        return ResponseEntity.ok("Product removed from restaurant stock successfully!");
    }

    @PostMapping("/{email}/update-product")
    public ResponseEntity<String> updateProductFromRestaurantStock(
            @PathVariable String email,
            @RequestBody String productName,
            @RequestBody Product product) {
        restaurantService.updateProductInStock(email, productName, product);
        return ResponseEntity.ok("Product updated from restaurant stock successfully!");
    }

    @PostMapping("/{email}/get-stock")
    public ResponseEntity<List<Product>> getRestaurantStock(
            @PathVariable String email) {
        return ResponseEntity.ok(restaurantService.getProductStock(email));
    }
}
