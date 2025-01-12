package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Classes.Restaurant;
import com.foodest.foodest.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String description, Double price, String imgUrl, Restaurant restaurant){
        if(!productRepository.existsByName(name)){
            Product product = new Product(name, description, price, imgUrl, restaurant);
            productRepository.save(product);
            return product;
        }
        return null;
    }

    public List<Product> getAllProducts() {}

    public Product getProductById(Long id) {}

    public Product updateProduct(Long id, String name, String description, Double price, String imgUrl, Restaurant restaurant) {}

    public void deleteProduct(Long id) {}
}
