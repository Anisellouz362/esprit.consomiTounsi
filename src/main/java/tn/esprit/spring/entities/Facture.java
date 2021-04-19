package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Facture  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Enumerated(EnumType.STRING)
	private Typepayment Typepayment;
	@Temporal (TemporalType.DATE)
	private Date datefacture ;
	private String adresse;
	private String amount;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Typepayment getTypepayment() {
		return Typepayment;
	}
	public void setTypepayment(Typepayment typepayment) {
		Typepayment = typepayment;
	}
	public Date getDatefacture() {
		return datefacture;
	}
	public void setDatefacture(Date datefacture) {
		this.datefacture = datefacture;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Facture() {
		
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}

	
	
	

