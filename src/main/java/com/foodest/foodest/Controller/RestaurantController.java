package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.Restaurant;
import com.foodest.foodest.Repository.RestaurantRepository;
import com.foodest.foodest.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService RestaurantService;
}
