package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entities.Role;

public interface IRoleService {
	public Role save(Role r);
	List<Role> retrieveAllRoles();
	void deleteRole(long id);
	Role updateRole(Role r);
	

}
