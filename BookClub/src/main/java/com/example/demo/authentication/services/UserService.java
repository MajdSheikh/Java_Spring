package com.example.demo.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;


import com.example.demo.authentication.models.LoginUser;
import com.example.demo.authentication.models.User;
import com.example.demo.authentication.repositories.UserRepository;


@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    
    public User register(User newUser, BindingResult result) {
    	// in order to register, check if the email already exists in the database:
    	 if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {		
    	        result.rejectValue("email", "Unique", "This email is taken!");
    	    }
    	 // check if the username who is trying to register already exists in the database
    	 if(userRepo.findByUserName(newUser.getUserName()).isPresent()) {
    	        result.rejectValue("userName", "Unique", "This Name is already in use!");
    	    }
    	 // check if the given password matches the confirm password
    	 if(!newUser.getPassword().equals(newUser.getConfirm())) {		
    	        result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
    	    }
    	 // check if there are errors in the registration form
    	 if(result.hasErrors()) {									
    	        return null;
    	    } else {	//if not,  BCrypt hash the password then create a new User
    	        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	        newUser.setPassword(hashed); // set the hashed password in the database instead of the given password by the user
    	        return userRepo.save(newUser);
    	    }
    }
    
    // login method
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
        
        

public User findUserById(Long id) {
    Optional<User> u = userRepo.findById(id);

    if(u.isPresent()) {
        return u.get();
        } else {
        return null;
    }
}
}
 



