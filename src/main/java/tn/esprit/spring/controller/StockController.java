package tn.esprit.spring.controller;

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

import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.IStockSerivce;
@Scope(value = "session")
@Controller(value = "stockController")

@ELBeanName(value = "stockController") // nous permettons d'acceder les
											// variable a partir du code html
											// ex: usereController.Login

@Join(path = "/stock", to = "/stock.jsf")
public class StockController {
	
	@Autowired
	IStockSerivce ES;
	
	private int idStock;
	private String nameStock;
	private String fournisseur;
	private int quantityStock;
	@Temporal(TemporalType.TIMESTAMP)

	private Date entryDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")

	
	private List<Stock> stocks;
	

	
	private int stockIdToBeUpdated;

	
	// add function 
	
	/*public String addStock() {
	String navigateTo = null;
	ES.save(((new Stock( nameStock,fournisseur,quantityStock ))));
	navigateTo = "/stock.xhtml?faces-redirect=true";
	return navigateTo;

	}*/public void addStock() {
		
		ES.save(new Stock( nameStock,fournisseur,quantityStock,entryDate ));

		}


	
	public List<Stock> OutOfStockDetector(){
		stocks = ES.OutOfStockDetector();
		return stocks;

	}
	
	
	
	
	// get all rayons
	
	public List<Stock> getstocks() {
		stocks = ES.retrieveAllStock();
		return stocks;
	}
	
	// remove rayon
	
	public String removeStock(long eventId) {
		String navigateTo = null;
		ES.deleteStock(eventId);
		navigateTo = "/stock.xhtml?faces-redirect=true";
		return navigateTo;
	}
	public String stockpdf(long eventId) {
		String navigateTo = null;
		ES.stockpdf(eventId);
		navigateTo = "/stock.xhtml?faces-redirect=true";
		return navigateTo;
	}
	
	
	// dispaly events
	public void displayStock(Stock ray)
	{
	this.setNameStock(ray.getNameStock());
	this.setFournisseur(ray.getFournisseur());
	this.setQuantityStock(ray.getQuantityStock());
	this.setEntryDate(ray.getEntryDate());

	this.setStockIdToBeUpdated(ray.getIdStock());
	}
	// update event
	
	
	public void updateStock()
	{
		ES.updateStock(new Stock(stockIdToBeUpdated,nameStock,fournisseur,quantityStock,entryDate));
		}

	
	
	public StockController() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	public int getStockId() {
		return idStock;
		
		
	}

	public void setStockId(int rayId) {
		this.idStock = rayId;
	}

	public String getNameStock() {
		return nameStock;
	}

	public void setNameStock(String RayName) {
		this.nameStock = RayName;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String RayType) {
		this.fournisseur = RayType;
	}


	public int getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(int quantity) {
		this.quantityStock = quantity;
	}
	
	
	public void setStockIdToBeUpdated(int RayIdToBeUpdated) {
		this.stockIdToBeUpdated = RayIdToBeUpdated;
	}

	public int getStockIdToBeUpdated() {
		return stockIdToBeUpdated;
	}

	
	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date endsdate) {
		this.entryDate = endsdate;
	}
	
}
