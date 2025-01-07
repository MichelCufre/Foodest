package com.foodest.foodest.Controller;
import com.foodest.foodest.Classes.User;
import com.foodest.foodest.Repository.UserRepository;
import com.foodest.foodest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUserResponse(@RequestBody User user) {
        User newUser = userService.registerUser(user.getName(),user.getEmail(),user.getPassword(),user.getImgUrl());
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Servidor funcionando correctamente";
    }
}
