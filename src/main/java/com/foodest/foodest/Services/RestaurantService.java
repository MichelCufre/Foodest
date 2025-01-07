package com.foodest.foodest.Services;
import org.springframework.beans.factory.annotation.Autowired;
import com.foodest.foodest.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import com.foodest.foodest.Classes.Product;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void addProductToStock(Product product) {
    }

    public void removeProductFromStock(Long productId){
    }

    public Product updateProductInStock(Long productId, Product updatedProduct){
    }

    public List<Product> getProductStock(){
    }

}
