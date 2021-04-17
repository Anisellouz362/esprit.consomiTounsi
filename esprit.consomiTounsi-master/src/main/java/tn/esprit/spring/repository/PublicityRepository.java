package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Publicity;


public interface PublicityRepository extends JpaRepository <Publicity , Integer> {

	Publicity findByName (String name);


}
