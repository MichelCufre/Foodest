package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.foodest.foodest.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email, String password, String imgUrl){
        User user = new User();
        if(!userRepository.existsByEmail(email)){
            user = new User(name, email, password, imgUrl);
            userRepository.save(user);

        }
        return user;
    }
}
