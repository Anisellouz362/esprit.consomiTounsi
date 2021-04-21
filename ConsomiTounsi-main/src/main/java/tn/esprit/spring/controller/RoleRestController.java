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

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.service.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleRestController {

	@Autowired
	RoleService RS; 
	
	

		@PostMapping("/add-role")
		@ResponseBody
		public Role saveRole(@RequestBody Role r) {
			Role rolee = RS.save(r);
			return rolee;
			}
		

		@GetMapping("/retrieve-all-Role")
		@ResponseBody
		public List<Role> getRole() {
		List<Role> list = RS.retrieveAllRoles();
		return list;
		}
		

		@DeleteMapping("/remove-Role/{id}")
		@ResponseBody
		public void removeUser(@PathVariable("id") long id) {
		RS.deleteRole(id);
		}
		

		@PutMapping("/modify-Role/")
		@ResponseBody
		public Role modifyRole(@RequestBody Role r) {
		return RS.updateRole(r);
		}
		
		// http://localhost:8083/SpringMVC/servlet/Role/add-role
		// http://localhost:8083/SpringMVC/servlet/Role/retrieve-all-Role
		// http://localhost:8083/SpringMVC/servlet/Role/remove-Role/{id}
		// http://localhost:8083/SpringMVC/servlet/Role/modify-Role

		

}
