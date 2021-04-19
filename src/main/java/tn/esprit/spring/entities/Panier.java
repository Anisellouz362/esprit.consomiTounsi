package tn.esprit.spring.entities;

import java.io.Serializable;
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
public class Panier implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal (TemporalType.DATE)
	private Date datepayment;
	@Enumerated(EnumType.STRING)
	private Typepayment Typepayment;

	public Panier() {
		
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDatepayment() {
		return datepayment;
	}
	public void setDatepayment(Date datepayment) {
		this.datepayment = datepayment;
	}
	public Typepayment getTypepayment() {
		return Typepayment;
	}
	public void setTypepayment(Typepayment typepayment) {
		Typepayment = typepayment;
	}

	
}
