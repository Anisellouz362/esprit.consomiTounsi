package tn.esprit.spring.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Panier;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.PanierRepository;
import tn.esprit.spring.service.BillService;
import tn.esprit.spring.service.PanierService;
import tn.esprit.spring.service.ProductService;





@Scope(value = "session")
@Controller(value = "productController")
@ManagedBean
@SessionScoped
@ELBeanName(value = "productController") 
@Join(path = "/Producttest", to = "/Producttest.jsf")


public class ProductController {
	@Autowired
	ProductService bs;
	@Autowired
	PanierService ps;
	@Autowired
	PanierRepository pr;
	private Long idProd;
	 private float Price;
	  private String name;
	private List<Product> product;

	public List<Product> getProduct() {
		product = bs.getProducts();
		return product;
	}

	public String cartPage() {
		
		String navigateTo = null;
		
		navigateTo = "/Cart.xhtml?faces-redirect=true";
		return navigateTo;
	}
	

	public Long getIdProd() {
		return idProd;
	}

	public void setIdProd(Long idProd) {
		this.idProd = idProd;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
