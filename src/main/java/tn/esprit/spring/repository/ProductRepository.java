package tn.esprit.spring.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;



public interface ProductRepository  extends JpaRepository <Product , Long> {

	Product findByName (String name);

	@Query(value = "SELECT * FROM product WHERE id_prod=?1", nativeQuery = true)
	public Product getOne(Long id);
	
}
