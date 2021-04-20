package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Typepayment;
import tn.esprit.spring.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	BillRepository br;
	private static final Logger L =  LogManager.getLogger(BillServiceImpl.class);
	@Override
	public Facture save(Facture facture) {
		// TODO Auto-generated method stub
		return br.save(facture);
	}
	@Override
	public List<Facture> getAllBill() {
		List<Facture> factures = (List<Facture>) br.findAll();
		for (Facture facture : factures){
		L.info("facture +++: " + factures);}
		return factures;

	}
	@Override
	public void deleteBill(Long id) {
		
		Optional<Facture> facture = br.findById(id);
	    
	    if(facture.isPresent()) 
	    {
	       br.deleteById(id);
	       }	}
@Override 
public Facture updateBill(Facture fr){
			
			return br.save(fr);
		}
@Override
public Optional<Facture> getBill_by_ID(Long id) {
	return br.findById(id);
}
/*
@Override
public List<Facture> getBill_by_Type(Typepayment paymentType){
   return br.findByTypepayment(paymentType);
}
}*/

@Override
public void modify_type_bill(Typepayment paymentType, Long id) {
	Facture fr =br.findById(id).get();
	fr.setTypepayment(paymentType);
		br.save(fr);
	}

@Override
public String  get_payment_type_by_id(Long id) {
	
	 return br.get_payment_type_by_id(id);
}

}
 

	
	

