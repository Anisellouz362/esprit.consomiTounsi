package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;


public interface CommandeRepository extends CrudRepository<Commande,Long>{
	@Query(value = "SELECT * FROM commande WHERE id=?1", nativeQuery = true)
	public Commande getOne(long id);
}
