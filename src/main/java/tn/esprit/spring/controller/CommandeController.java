package tn.esprit.spring.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Commande;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.Typepayment;
import tn.esprit.spring.service.CommandeService;


@Scope(value = "session")
@Controller(value = "commandeController")

@ELBeanName(value = "commandeController") 
@Join(path = "/Commande", to = "/Commande.jsf")
public class CommandeController {
	@Autowired
	CommandeService cs;
	
	
private Long idcom;
	private String name;
	private String prenom;
	private String productname;
	private int qnt;
	private String adresse;
	private float montantUN;
	private float montantHT;
	private Typepayment paymenttype;
	private Date commandDate;
	public Typepayment[] getTypepayment() { return Typepayment.values(); }
	private List<Commande> commande;
	
	public String addCommande() {
		String navigateTo = null;
		float total=qnt*montantUN;
		cs.savecommande((new Commande(name,prenom,productname,qnt,montantUN,total,paymenttype,commandDate,adresse)));
		navigateTo = "/commande.xhtml?faces-redirect=true";
		return navigateTo;
		}
	
	public void displaycommandes(Commande pan)
	{
	this.setProductname(pan.getProductname());
	this.setName(pan.getName());
	this.setPrenom(pan.getPrenom());
	this.setPaymenttype(pan.getCommandType());
	this.setMontantUN(pan.getMontantUN());
	this.setIdcom(pan.getId());
	this.setQnt(pan.getQnt());
	this.setAdresse(pan.getCommandAdresse());
	this.setCommandDate(pan.getCommandDate());
	}
	public String displaycommande(Product product)
	{
		String navigateTo = null;
		navigateTo = "/Commande.xhtml?faces-redirect=true";
		this.setMontantUN(product.getPrice());
		this.setIdcom(product.getIdProd());
		this.setProductname(product.getName());
		return navigateTo;
	}

	public void updatecommande()
	{
		float total=qnt*montantUN;
		cs.updatecommande(new Commande(name,prenom,productname,qnt,montantUN,total,paymenttype,commandDate,adresse));
		}
	
	public String removeCommande(Long Idcommande) {
		String navigateTo = null;
		cs.deletecommande(Idcommande);
		navigateTo = "/Commandeadmin.xhtml?faces-redirect=true";
		return navigateTo;
	}

	public List<Commande> getCommande() {
		commande = cs.getAllcommande();
		return commande;
	}

	public void setCommande(List<Commande> commande) {
		this.commande = commande;
	}

	public Long getIdcom() {
		return idcom;
	}


	public void setIdcom(Long idcom) {
		this.idcom = idcom;
	}





	public float getMontantUN() {
		return montantUN;
	}

	public void setMontantUN(float montantUN) {
		this.montantUN = montantUN;
	}

	public Date getCommandDate() {
		return commandDate;
	}


	public void setCommandDate(Date commandDate) {
		this.commandDate = commandDate;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public float getMontantHT() {
		return montantHT;
	}
	public void setMontantHT(float montantHT) {
		this.montantHT = montantHT;
	}
	public Typepayment getPaymenttype() {
		return paymenttype;
	}
	public void setPaymenttype(Typepayment paymenttype) {
		this.paymenttype = paymenttype;
	}
	
	
	public void printCommande(long idcommande) throws IOException {
		cs.commandepdf(idcommande);
		cs.uploadpdf(idcommande);
		

}
	
	
}
