package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service

public class UserService implements IUserService {
	@Autowired
UserRepository ur; 
	private static final Logger L =  LogManager.getLogger(IUserService.class);

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
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
	      //  newUser.setRoles(user.getRoles());

	        

	         
	        return newUser;
	    } else {
	        user = ur.save(user);
	         
	        return user;
	    }
	}

}
