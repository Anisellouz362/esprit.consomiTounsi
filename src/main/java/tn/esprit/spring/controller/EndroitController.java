package tn.esprit.spring.controller;



import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Endroit;
import tn.esprit.spring.service.EndroitService;

@Scope(value = "session")
@Controller(value = "endroitController")

@ELBeanName(value = "endroitController") // nous permettons d'acceder les
											// variable a partir du code html
											// ex: usereController.Login

@Join(path = "/endroit", to = "/endroit.jsf")
public class EndroitController {
	@Autowired
	EndroitService er;
	
	private long id;
	private String emplacement;
	private int nbplace;
	private String statu;
	public String getStatu() {
		return statu;}
		
		
		private List<Endroit> endroit;
		
		
		
		// add function 
		public String addendroit() {
			String navigateTo = null;
			er.save(((new Endroit(emplacement, nbplace, statu ))));
			navigateTo = "/endroit.xhtml?faces-redirect=true";
			return navigateTo;
		}
		
		
		
		// get all endroit
		
		public List<Endroit> getEndroit() {
			endroit = er.retrieveAllEndroit();
			return endroit;
		}
		
		// remove endroit
		
		public String removeEndroit(long endroittId) {
			String navigateTo = null;
			er.deleteEndroit(endroittId);
			navigateTo = "/endroit.xhtml?faces-redirect=true";
			return navigateTo;
		}
		
		
		// dispaly Endroit
		public void displayEndroit(Endroit end)
		{
		this.setEmplacement(end.getEmplacement());
		this.setNbplace(end.getNbplace());
		this.setId(end.getId());
		this.setStatu(end.getStatu());
		}
		// update event
		public void updateEndroit()
		{
			er.updateEndroite(new Endroit(id,emplacement,nbplace , statu));
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	public EndroitController() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public int getNbplace() {
		return nbplace;
	}
	public void setNbplace(int nbplace) {
		this.nbplace = nbplace;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
	
}
