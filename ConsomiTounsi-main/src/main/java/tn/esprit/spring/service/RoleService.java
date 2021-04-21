package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.RoleRepository;

@Service
public class RoleService implements IRoleService{

	@Autowired
	RoleRepository rr; 
	private static final Logger L =  LogManager.getLogger(IRoleService.class);
	
	@Override
	public Role save(Role r) {
		// TODO Auto-generated method stub
		return rr.save(r);
	}
	
	
	
	@Override
	public List<Role> retrieveAllRoles() {
		// TODO Auto-generated method stub
		List<Role> role = (List<Role>) rr.findAll();
		for (Role rolee : role){
		L.info("role +++: " + rolee );}
		return role;	}
	
	
	
	@Override
	public void deleteRole(long id) {
Optional<Role> role = rr.findById(id);
	    
	    if(role.isPresent()) 
	    {
	        rr.deleteById(id);}	

		
	}
	@Override
	public Role updateRole(Role r) {
		Optional<Role> rolee = rr.findById(r.getId());
		if(rolee.isPresent()) 
	    {
		     Role newRole = rolee.get();
		     newRole.setId(r.getId());
		     newRole.setRole(r.getRole());
		     newRole.setDesc(r.getDesc());
		  

	         
	        return newRole;
	    } else {
	        r = rr.save(r);
	         
	        return r;
	    }	}

	
}
