package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillRepository br;
	private static final Logger L =  LogManager.getLogger(EventServiceImpl.class);
	@Override
	public Facture save(Facture facture) {
		// TODO Auto-generated method stub
		return br.save(facture);
	}
	@Override
	public List<Facture> getAllBill() {
		List<Facture> factures = (List<Facture>) br.findAll();
		for (Facture facture : factures){
		L.info("event +++: " + factures);}
		return factures;

	}
	@Override
	public void deleteBill(long id) {
		
		Optional<Facture> facture = br.findById(id);
	    
	    if(facture.isPresent()) 
	    {
	       br.deleteById(id);
	       }	}
@Override 
public Facture updateBill(Facture fr){
			
			return br.save(fr);
		}}
	
	

