package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Stock;

public interface IStockSerivce {
	
	public int ajouterStock(Stock stock);
	public void deleteStock(int IdStock);
	public void UpdateStock(int IdStock,String NameStock, int QuantityStock);
	public List<Stock> ShowStock();
	public List<Stock> ShowStockbyName(String NameStock);
	public List<Stock> ShowStockbyQuantity(int QuantityStock);

	
	
	

}