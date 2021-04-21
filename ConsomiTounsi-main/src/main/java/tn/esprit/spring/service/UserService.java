package tn.esprit.spring.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.RoleRepository;
import tn.esprit.spring.repository.UserRepository;

@Service

public class UserService implements IUserService {
	@Autowired
UserRepository ur; 
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository rr;
	
	private static final Logger L =  LogManager.getLogger(IUserService.class);

	@Override
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = rr.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
			return ur.save(user);
	}

	@Override
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		
		List<User> user = (List<User>) ur.findAll();
		for (User userr : user){
		L.info("user +++: " + userr );}
		return user;

		
	
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		Optional<User> user = ur.findById(id);
	    
	    if(user.isPresent()) 
	    {
	        ur.deleteById(id);}	
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userr = ur.findById(user.getId());
		if(userr.isPresent()) 
	    {
		     User newUser = userr.get();
	        newUser.setSalary(user.getSalary());
	        newUser.setName(user.getName());
	        newUser.setEmail(user.getEmail());
	        newUser.setPhone(user.getPhone());
	        newUser.setPassword(user.getPassword());
	        newUser.setAdress(user.getAdress());
	        newUser.setRoles(user.getRoles());

	        

	         
	        return newUser;
	    } else {
	        user = ur.save(user);
	         
	        return user;
	    }
	}

	@Override
	public boolean isUserAlreadyPresent(User user) {
		// TODO Auto-generated method stub
		boolean isUserAlreadyExists = false; 
		
		if(true == true) {
			
		}
		
		return isUserAlreadyExists;
	}

	
}
