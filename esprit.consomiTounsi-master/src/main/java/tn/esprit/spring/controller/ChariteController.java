package tn.esprit.spring.controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Charite;
import tn.esprit.spring.service.ChariteService;

@Scope(value = "session")
@Controller(value = "chariteController")

@ELBeanName(value = "chariteController") // nous permettons d'acceder les
											// variable a partir du code html
											// ex: usereController.Login

@Join(path = "/charite", to = "/charite.jsf")
public class ChariteController {


@Autowired
ChariteService cr;

private long chariteIdToBeUpdated;
private String typecharite;
private float montantpaye;
public float total;
private List<Charite> charites;


public ChariteController(List<Charite> charites) {
	super();
	this.charites = charites;
}



// add function 
public String addcharite() {
	String navigateTo = null;
	cr.save(((new Charite( typecharite, montantpaye ))));
	navigateTo = "/charite.xhtml?faces-redirect=true";
	return navigateTo;
}


//get all Charite

	public ChariteController(long chariteIdToBeUpdated, String typecharite, float montantpaye, List<Charite> charites ,float total) {


	this.chariteIdToBeUpdated = chariteIdToBeUpdated;
	this.typecharite = typecharite;
	this.montantpaye = montantpaye;
	this.charites = charites;
	this.total = total;
}


	public List<Charite> getCharite() {
		charites = cr.retrieveAllCharite();
		return charites;
	}


	// remove charite
	public String removeCharite(long ChariteId) {
		String navigateTo = null;
		cr.deleteCharite(ChariteId);
		navigateTo = "/charite.xhtml?faces-redirect=true";
		return navigateTo;
	}


	// dispaly charite
	public void displayCharite(Charite chr)
	{
	this.setTypecharite(chr.getTypecharite());
	this.setChariteIdToBeUpdated(chr.getId());
	this.setMontantpaye(chr.getMontantpaye());
	this.setTotal(cr.TotalDonation());
	}

	// update event
	public void updateCharite()
	{
		cr.updateCharite(new Charite(chariteIdToBeUpdated, typecharite, montantpaye));
		}



		




	


	public float getTotal() {
		return total;
	}



	public void setTotal(float total) {
		this.total = total;
	}



	public ChariteController() {
		super();
	
	}


	public String getTypecharite() {
		return typecharite;
	}


	public void setTypecharite(String typecharite) {
		this.typecharite = typecharite;
	}


	public float getMontantpaye() {
		return montantpaye;
	}


	public void setMontantpaye(float montantpaye) {
		this.montantpaye = montantpaye;
	}



	public void setChariteIdToBeUpdated(long chariteIdToBeUpdated) {
		this.chariteIdToBeUpdated = chariteIdToBeUpdated;
	}



	
}
	
	