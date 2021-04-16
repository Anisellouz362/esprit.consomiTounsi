package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import tn.esprit.spring.entities.Product;

@Entity 
@Table(name="Ray")

public class Ray implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Ray_Id")
	private int RayId;
	@Column(name = "Ray_Name")
	private String RayName;
	@Column(name = "Ray_Type")
	private String RayType;
	@Column(name = "Arrangement_Type")
	private String ArranType;
	@Column(name = "Ray_Capacity")
	private int RayCapacity;
	
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

	public String getRayType() {
		return RayType;
	}

	public void setRayType(String rayType) {
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
	
	

}