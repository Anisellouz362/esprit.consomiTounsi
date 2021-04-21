package tn.esprit.spring.service;

import java.util.List;
import tn.esprit.spring.entities.role;

public interface IRoleService {
	public role save(role r);
	List<role> retrieveAllRoles();
	void deleteRole(long id);
	role updateRole(role r);
	

}
