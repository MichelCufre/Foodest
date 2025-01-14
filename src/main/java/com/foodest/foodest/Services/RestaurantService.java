package com.foodest.foodest.Services;
import com.foodest.foodest.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.foodest.foodest.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Classes.Restaurant;

import java.util.List;

@Service
public class RestaurantService {

    private static RestaurantRepository restaurantRepository;
    private static ProductRepository productRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        RestaurantService.restaurantRepository = restaurantRepository;
    }

    public static Restaurant registerRestaurant(String name, String email, String password, String imgUrl, List<Product> productStock) {
        // Verificar si el restaurante ya existe por email
        if (restaurantRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Restaurant with email " + email + " already exists!");
        }

        // Crear y guardar el nuevo restaurante
        Restaurant restaurant = new Restaurant(name, email, password, imgUrl, productStock);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public void addProductToStock(String email, Product product) {
        Restaurant restaurant = restaurantRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Restaurant not found with email: " + email));
        if(!productRepository.existsByName(product.getName())){
            restaurant.getProductStock().add(product);
            restaurantRepository.save(restaurant);
        }
    }

    public void removeProductFromStock(String email, Product product){
        if(restaurantRepository.existsByEmail(email)){
            Restaurant restaurant = restaurantRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with email: " + email));
            if(productRepository.existsByName(product.getName())){
                restaurant.getProductStock().remove(product);
                restaurantRepository.save(restaurant);
            }
        }
    }

    public void updateProductInStock(String email, String productName, Product updatedProduct){
        if(restaurantRepository.existsByEmail(email)){
            Restaurant restaurant = restaurantRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with email: " + email));

                for(Product product : restaurant.getProductStock()){
                    if(product.getName().equals(productName)){
                        product = updatedProduct;
                    }
                }
                restaurantRepository.save(restaurant);

        }
    }

    public List<Product> getProductStock(String email){
        if(restaurantRepository.existsByEmail(email)){
            Restaurant restaurant = restaurantRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with email: " + email));
            return restaurant.getProductStock();
        }
        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));
    }
}
