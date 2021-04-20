package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Product;



public interface ProductRepository  extends JpaRepository <Product , Integer> {

	Product findByName (String name);

}
