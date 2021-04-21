package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserService;

@RestController
@RequestMapping("/User")
public class UserRestController {

	@Autowired
	UserService US; 
	
	@PostMapping("/add-user")
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		User userr = US.save(user);
		return userr;
		}
	

	@GetMapping("/retrieve-all-User")
	@ResponseBody
	public List<User> getUser() {
	List<User> list = US.retrieveAllUser();
	return list;
	}
	
	// http://localhost:8083/SpringMVC/servlet/User/remove-User/{id}

	@DeleteMapping("/remove-User/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") long id) {
	US.deleteUser(id);
	}
	
	// http://localhost:8083/SpringMVC/servlet/User/modify-User

	@PutMapping("/modify-User/")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return US.updateUser(user);
	}
	
	
	// http://localhost:8083/SpringMVC/servlet/User/add-user
	// http://localhost:8083/SpringMVC/servlet/User/retrieve-all-User
	// http://localhost:8083/SpringMVC/servlet/User/remove-User/{id}
	// http://localhost:8083/SpringMVC/servlet/User/modify-User

	
}
