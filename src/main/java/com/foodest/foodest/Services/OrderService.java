package com.foodest.foodest.Services;
import org.springframework.beans.factory.annotation.Autowired;
import com.foodest.foodest.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private UserRepository userRepository;
}
