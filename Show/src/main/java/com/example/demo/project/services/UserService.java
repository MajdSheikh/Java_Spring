package com.example.demo.project.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.project.models.LoginUser;
import com.example.demo.project.models.User;
import com.example.demo.project.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	

//	Authenticate User
	public User authenticate(LoginUser loginUser) {
		
		Optional<User> foundUser = userRepo.findByEmail(loginUser.getEmail());
		
		if(foundUser.isEmpty()) {
			return null;
		}
		
		if(!BCrypt.checkpw(loginUser.getPassword(), foundUser.get().getPassword())) {
			return null;
		}
		
		return foundUser.get();
	}
	
	
//	Create User
	public User createUser(User newUser) {
		
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
		
		return userRepo.save(newUser);
	}
	
//	Check that user is in session
	public User getSessionUser(HttpSession session) {
		
		if(session.getAttribute("userId") == null) return null;
		
		return getUser((Long) session.getAttribute("userId"));
	}
	
	
//	Get All Users
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

//	Get one User by ID
	public User getUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
//	Get one User by email
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email).orElse(null);
	}

//	Update A User
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
//	Delete User
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	
	
}