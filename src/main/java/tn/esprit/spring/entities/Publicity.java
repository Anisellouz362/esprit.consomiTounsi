package tn.esprit.spring.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Publicity {
	
	private enum TypePub {
		ProductEvent,ProdPub,  ProductPub,ProdEvent;
		}
	
	@Id
	@GeneratedValue
     private int idPub;
	@Column(name = "name")
    private String name;
	@Column(name = "Description")
    private String Description;
	@Enumerated(EnumType.STRING)
   private TypePub typepub;
	@ManyToMany(mappedBy = "publicitys", cascade = CascadeType.ALL)
	 private Collection<Product> products =new ArrayList() ;

	public Publicity() {
		super();
	}
	public Publicity(int idPub, String name, String description, TypePub typepub, Collection<Product> products) {
		super();
		this.idPub = idPub;
		this.name = name;
		Description = description;
		this.typepub = typepub;
		this.products = products;
	}
	public Collection<Product> getProducts() {
		return products;
	}
	public void setProducts(Collection<Product> products) {
		this.products = products;
	}
	public int getIdPub() {
		return idPub;
	}
	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public TypePub getTypepub() {
		return typepub;
	}
	public void setTypepub(TypePub typepub) {
		this.typepub = typepub;
	}
	@Override
	public String toString() {
		return "Publicity [name=" + name + ", Description=" + Description + ", typepub=" + typepub + "]";
	}
	
	
	
	
	

}
