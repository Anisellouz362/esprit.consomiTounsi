package tn.esprit.spring.controller;

import tn.esprit.spring.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.service.RayService;

@Scope(value = "session")
@Controller(value = "rayController")

@ELBeanName(value = "rayController") // nous permettons d'acceder les
// variable a partir du code html
// ex: usereController.Login

@Join(path = "/ray", to = "/ray.jsf")
public class RayController {

	@Autowired
	RayService ES;

	private int rayId;
	private String rayName;
	private Typeray rayType;
	private String 	arranType;
	private int rayCapacity;


	private List<Ray> rayons;


	public Typeray[] getRayTypes() { return Typeray.values(); }


	private int rayIdToBeUpdated;


	// add function 
	public String addrayon() {
		String navigateTo = null;
		ES.save(((new Ray( rayName,rayType,rayCapacity ))));
		navigateTo = "/ray.xhtml?faces-redirect=true";
		return navigateTo;
	}

	// get all rayons

	public List<Ray> getRayons() {
		rayons = ES.retrieveAllRay();
		return rayons;
	}

	// remove rayon

	public String removeRay(long eventId) {
		String navigateTo = null;
		ES.deleteRay(eventId);
		navigateTo = "/ray.xhtml?faces-redirect=true";
		FacesMessage facesMessage= new FacesMessage("suprimé");
		FacesContext.getCurrentInstance().addMessage("form:btn", facesMessage);
		return navigateTo;
	}



	// dispaly events
	public void displayRay(Ray ray)
	{
		this.setRayName(ray.getRayName());
		this.setRayType(ray.getRayType());
		this.setRayCapacity(ray.getRayCapacity());
		this.setRayIdToBeUpdated(ray.getRayId());
	}
	// update event


	public void updateRay()
	{
		ES.updateRay(new Ray(rayIdToBeUpdated,rayName,rayType,rayCapacity));
	}



	public RayController() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getRayId() {
		return rayId;


	}

	public void setRayId(int rayId) {
		this.rayId = rayId;
	}

	public String getRayName() {
		return rayName;
	}

	public void setRayName(String RayName) {
		this.rayName = RayName;
	}


	public Typeray getRayType() {
		return rayType;
	}

	public void setRayType(Typeray RayType) {
		this.rayType = RayType;
	}

	public String getAranType() {
		return arranType;
	}

	public void setArranType(String ArranType) {
		this.arranType = ArranType;
	}

	public int getRayCapacity() {
		return rayCapacity;
	}

	public void setRayCapacity(int RayCapacity) {
		this.rayCapacity = RayCapacity;
	}


	public void setRayIdToBeUpdated(int RayIdToBeUpdated) {
		this.rayIdToBeUpdated = RayIdToBeUpdated;
	}

	public int getRayIdToBeUpdated() {
		return rayIdToBeUpdated;
	}

}