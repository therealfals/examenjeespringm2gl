package com.examenjava.isi.service;  
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.examenjava.isi.model.User;
import com.examenjava.isi.repository.UserRepository;  
 
@Service  
public class UserService
{  
@Autowired  
UserRepository userRepository;  
public List<User> getAllUsers()   
{  
List<User> users = new ArrayList<User>();  
users = userRepository.findAll();
return users;  
}  
public User getBooksById(int id)   
{  
return userRepository.findById(id).get();  
}  
public void addUser(User user)   
{  
	userRepository.save(user);  
}  
public void delete(int id)   
{  
	userRepository.deleteById(id);  
}  
public User findByEmail(String email) {
	User user = null;
	try {
		user = userRepository.findByEmail(email);
	} catch (Exception e) {
		throw e;
	}
	return user;
}
} 