package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Product;
import com.foodest.foodest.Classes.User;
import com.foodest.foodest.Repository.ProductRepository;
import com.foodest.foodest.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product.getName(), product.getDesc(), product.getPrice(), product.getImgUrl(), product.getRestaurant());
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }


}
