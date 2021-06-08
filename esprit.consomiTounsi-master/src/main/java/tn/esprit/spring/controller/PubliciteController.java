package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Publicite;
import tn.esprit.spring.service.PubliciteService;

import tn.esprit.spring.entities.EmailCfg;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;

@Scope(value = "session")
@Controller(value = "publiciteController")

@ELBeanName(value = "publiciteController") // nous permettons d'acceder les
											// variable a partir du code html
											// ex: usereController.Login

@Join(path = "/publicite", to = "/publicite.jsf")

public class PubliciteController {
	@Autowired
	PubliciteService pr;
	
	private long id;
	private String nom;
	//@Temporal(TemporalType.TIMESTAMP)
	private Date datedebut;
	private Date datefin;
	private EmailCfg emailCfg;

	
	private List<Publicite> publicite;
	
	// add function 
	public String addpublicite() {
		String navigateTo = null;
		pr.save(((new Publicite(nom, datedebut, datefin ))));
		navigateTo = "/publicite.xhtml?faces-redirect=true";
		return navigateTo;
	}
		// get all Pub
		
		public List<Publicite> getPublicite() {
			publicite = pr.retrieveAllPublicite();
			return publicite;
		}
		
		// remove Pub
		
		public String removePublicite(long publiciteId) {
			String navigateTo = null;
			pr.deletePublicite(publiciteId);
			navigateTo = "/publicite.xhtml?faces-redirect=true";
			return navigateTo;
		}
		// dispaly events
		public void displayPublicite(Publicite empl)
		{
		this.setDatedebut(empl.getDatedebut());
		this.setDatefin(empl.getDatefin());
		this.setNom(empl.getNom());
		this.setId(empl.getId());
		}
		// update event
		public void updatePublicite()
		{
			pr.updatePublicite(new Publicite(id, nom, datedebut, datefin));
			}

	
	
		// send mail
		public void sendmail(){
			
			 	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		        mailSender.setHost(this.emailCfg.getHost());
		        mailSender.setPort(this.emailCfg.getPort());
		        mailSender.setUsername(this.emailCfg.getUsername());
		        mailSender.setPassword(this.emailCfg.getPassword());

		        // Create an email instance
		        SimpleMailMessage mailMessage = new SimpleMailMessage();
		        mailMessage.setFrom("anis.ellouz1@esprit.tn");
		        mailMessage.setTo("new@event.com");
		        mailMessage.setSubject("New Event  " );
		        mailMessage.setText("test");

		        // Send mail
		        mailSender.send(mailMessage);
			
		}
		
		
		


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}


	public void setPublicite(List<Publicite> publicite) {
		this.publicite = publicite;
	}
	
	
	
	
	
	
	
	
	
	
	}
	