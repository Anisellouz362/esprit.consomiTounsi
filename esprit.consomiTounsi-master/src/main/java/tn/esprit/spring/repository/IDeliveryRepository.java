package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.Reclamations;



@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery, Long>{
	@Modifying
	@Transactional
	@Query(value="delete from Delivery d where d.id = ?1")
	void deleteDeliveryById(Long id);
	
	@Query(value = "SELECT * FROM t_delivery d WHERE d.client_id= :idClient " , nativeQuery =true)
	 List<Delivery> findByIdClient(@Param("idClient")Long idClient);
	
	
	
}
