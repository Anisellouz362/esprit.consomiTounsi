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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import tn.esprit.spring.entities.exception.ProduitTounsiException;


@Data
@AllArgsConstructor
@Entity
public class Product {

	private enum Categorie {
		 cat1,cat2, a , aaa;
		}
	@Id
	@GeneratedValue
     private int idProd;
	@Column(name = "name")
    private String name;
	@Column(name = "Price")
    private float Price;
	@Column(name = "Qte")
     private int Qte;
	@Column(name = "Codbar",nullable = false)
	private long Codbar;
	@Enumerated(EnumType.STRING)
   private Categorie categorie;
	@ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "publicity_produit",
     joinColumns = @JoinColumn(name = "idprod"),
     inverseJoinColumns = @JoinColumn(name = "idpub")
)
    @JsonIgnore
    private Collection<Publicity> publicitys =new ArrayList() ;
	
	
	public Product(int idProd, String name, float price, int qte, long codbar, Categorie categorie) {
		super();
		this.idProd = idProd;
		this.name = name;
		Price = price;
		Qte = qte;
		Codbar = codbar;
		this.categorie = categorie;
	}
	public Product() {
		super();
	}
	public Product(int idProd, String name, float price, int qte, long codbar, Categorie categorie,
			Collection<Publicity> publicitys) {
		super();
		this.idProd = idProd;
		this.name = name;
		Price = price;
		Qte = qte;
		Codbar = codbar;
		this.categorie = categorie;
		this.publicitys = publicitys;
	}
	
	
	public Collection<Publicity> getPublicitys() {
		return publicitys;
	}
	public void setPublicitys(Collection<Publicity> publicitys) {
		this.publicitys = publicitys;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public long getCodbar() {
		
        
            return Codbar;
	
			
}
	

	public void setCodbar(long codbar) throws ProduitTounsiException {
		String T=Long.toString(codbar);
		if (T.startsWith("619"))
		Codbar=codbar;
	else 
		throw new ProduitTounsiException("Produit n est pas Tounsi");
		
	}
	public Categorie getCategorie() {
		return categorie;
	}
	
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
