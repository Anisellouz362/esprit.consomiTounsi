package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.repository.PanierRepository;

@Service
public class PanierServiceImpl implements PanierService{
	@Autowired
	PanierRepository Pn;
	@Override
	public Panier savepan(Panier panier) {
		// TODO Auto-generated method stub
		return Pn.save(panier);
	}

}
