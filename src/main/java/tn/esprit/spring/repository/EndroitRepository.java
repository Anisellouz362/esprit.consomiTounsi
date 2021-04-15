package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Endroit;
@Repository
public interface EndroitRepository extends CrudRepository<Endroit,Long>{
	@Query(value = "SELECT * FROM endroit WHERE statu='disponible'", nativeQuery = true)
	public List<Endroit> ListeEndroit();

}
