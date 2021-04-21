package tn.esprit.spring.service;


import java.util.List;


import tn.esprit.spring.entities.VisiteVirtuelleEntity;

public interface VisiteVirtuelleService {
	
	List<VisiteVirtuelleEntity> retrieveAllVisitesVirtuelles();
	VisiteVirtuelleEntity addVisiteVirtuelle(VisiteVirtuelleEntity V1);
	void deleteVisiteVirtuelle(Long id);
	VisiteVirtuelleEntity updateVisiteVirtuelle(VisiteVirtuelleEntity V1);
	VisiteVirtuelleEntity retrieveVisiteVirtuelle(Long id);

}