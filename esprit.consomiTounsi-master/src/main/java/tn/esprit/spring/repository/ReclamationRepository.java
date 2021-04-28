package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Reclamations;


public interface ReclamationRepository extends JpaRepository<Reclamations, Long> {
	 
}