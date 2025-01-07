package com.foodest.foodest.Services;
import com.foodest.foodest.Classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.foodest.foodest.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String email, String password, String imgUrl){
        User user = new User();
        if(!userRepository.existsByEmail(email)){
            user = new User(name, email, password, imgUrl);
            userRepository.save(user);

        }
        return user;
    }

    public void updateUser(Long id, User updatedUser){

    }

    public void deleteUser(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
    }

    public Optional<User> getUserById(Long id){
        if(userRepository.existsById(id)){
            return userRepository.findById(id);
        }
        return null;
    }
}
