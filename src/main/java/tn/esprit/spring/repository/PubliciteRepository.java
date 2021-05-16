package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Publicite;
@Repository
public interface PubliciteRepository extends CrudRepository<Publicite, Long>{
	
	
	@Query(value = "SELECT * FROM publicite ORDER by datefin DESC LIMIT 5 ", nativeQuery = true)
	public List<Object[]> TopPub(); 


}
