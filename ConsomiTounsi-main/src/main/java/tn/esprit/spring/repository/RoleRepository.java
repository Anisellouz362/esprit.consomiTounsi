package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Role;

public interface RoleRepository  extends CrudRepository<Role,Long>{

	public Role findByRole(String role);
}
