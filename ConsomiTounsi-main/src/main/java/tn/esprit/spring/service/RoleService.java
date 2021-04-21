package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.role;
import tn.esprit.spring.repository.RoleRepository;

@Service
public class RoleService implements IRoleService{

	@Autowired
	RoleRepository rr; 
	private static final Logger L =  LogManager.getLogger(IRoleService.class);
	
	@Override
	public role save(role r) {
		// TODO Auto-generated method stub
		return rr.save(r);
	}
	
	
	
	@Override
	public List<role> retrieveAllRoles() {
		// TODO Auto-generated method stub
		List<role> role = (List<role>) rr.findAll();
		for (role rolee : role){
		L.info("role +++: " + rolee );}
		return role;	}
	
	
	
	@Override
	public void deleteRole(long id) {
Optional<role> role = rr.findById(id);
	    
	    if(role.isPresent()) 
	    {
	        rr.deleteById(id);}	

		
	}
	@Override
	public role updateRole(role r) {
		Optional<role> rolee = rr.findById(r.getId());
		if(rolee.isPresent()) 
	    {
		     role newRole = rolee.get();
		     newRole.setId(r.getId());
		     newRole.setRole(r.getRole());
		     newRole.setDesc(r.getDesc());
		  

	         
	        return newRole;
	    } else {
	        r = rr.save(r);
	         
	        return r;
	    }	}

	
}
