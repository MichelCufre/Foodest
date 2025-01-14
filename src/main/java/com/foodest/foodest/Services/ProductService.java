package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Classes.Restaurant;
import com.foodest.foodest.Repository.ProductRepository;
import com.foodest.foodest.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private RestaurantRepository restaurantRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String description, Double price, String imgUrl, Restaurant restaurant) {
        if (!productRepository.existsByName(name)) {
            Product product = new Product(name, description, price, imgUrl, restaurant);
            productRepository.save(product);
            return product;
        }
        return null;
    }

    public Product getProductById(Long id, String email) {
        Restaurant restaurant = restaurantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with email: " + email));

        // Busca el producto en la lista del restaurante
        return restaurant.getProductStock().stream()
                .filter(product -> product.getId().equals(id)) // Filtra el producto con el ID correspondiente
                .findFirst() // Obtiene el primer resultado
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id + " in restaurant: " + email));
    }

    public Product updateProduct(Long id, String name, String description, Double price, String imgUrl, String email) {
        Product product = getProductById(id, email);

        product.setName(name);
        product.setDesc(description);
        product.setPrice(price);
        product.setImgUrl(imgUrl);

        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id, String email) {
        Restaurant restaurant = restaurantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with email: " + email));

        // Busca el producto en la lista del restaurante
         Product product = restaurant.getProductStock().stream()
                .filter(productt -> productt.getId().equals(id))
                .findFirst() // Obtiene el primer resultado
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id + " in restaurant: " + email));

        // Elimina el producto de la lista del restaurante
        restaurant.getProductStock().remove(product);

        // Guarda los cambios del restaurante (actualiza la relación)
        restaurantRepository.save(restaurant);

        // Elimina el producto del repositorio de productos
        productRepository.delete(product);
    }
}
