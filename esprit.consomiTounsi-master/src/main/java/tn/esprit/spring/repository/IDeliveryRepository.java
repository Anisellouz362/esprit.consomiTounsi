package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Delivery;



@Repository
public interface IDeliveryRepository extends CrudRepository<Delivery, Long>{

}
