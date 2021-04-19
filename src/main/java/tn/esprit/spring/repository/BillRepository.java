package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Facture;







@Repository

public interface BillRepository extends CrudRepository<Facture,Long>{


	
}



	







