package tn.esprit.spring.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import tn.esprit.spring.entities.Product;

@Entity 
public class Ray implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RayId;
	private String RayName;
	private String ArranType;
	private int RayCapacity;
	@Enumerated(EnumType.STRING)
	private Typeray RayType;
	
	//@OneToMany(mappedBy="ray")
	//private List<Produit> produit;
	

	public int getRayId() {
		return RayId;
		
		
		
	}

	public void setRayId(int rayId) {
		RayId = rayId;
	}

	public String getRayName() {
		return RayName;
	}

	public void setRayName(String rayName) {
		RayName = rayName;
	}

	public Typeray getRayType() {
		return RayType;
	}

	public void setRayType(Typeray rayType) {
		RayType = rayType;
	}

	public String getArranType() {
		return ArranType;
	}

	public void setArranType(String arranType) {
		ArranType = arranType;
	}

	public int getRayCapacity() {
		return RayCapacity;
	}

	public void setRayCapacity(int rayCapacity) {
		RayCapacity = rayCapacity;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Ray(String rayname, Typeray rayType,int rayCapacity) {
		super();
		this.RayName = rayname;
		this.RayType = rayType;
		this.RayCapacity = rayCapacity;

	}
	public Ray(String rayname, Typeray rayType, String arranType,int rayCapacity) {
		super();
	
		this.RayName = rayname;
		this.RayType = rayType;
		this.ArranType = arranType;
		this.RayCapacity = rayCapacity;

	}

	public Ray() {
	}

	public Ray(int id, String eventname, Typeray startdate, String endsdate, int publicite) {
		super();
		this.RayId = id;
		this.RayName = eventname;
		this.RayType = startdate;
		this.ArranType = endsdate;
		this.RayCapacity = publicite;
	}

	public Ray(int id, String eventname, Typeray startdate, int endsdate) {
		super();
		this.RayId = id;
		this.RayName = eventname;
		this.RayType = startdate;
		this.RayCapacity = endsdate;
	}
	
	

}