package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Facture;

public interface BillService {
	public Facture save(Facture facture);

	List<Facture> getAllBill();

	public Facture updateBill(Facture fr);

	void deleteBill(long id);
}
