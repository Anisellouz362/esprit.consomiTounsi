package tn.esprit.spring.service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Stock;

import tn.esprit.spring.repository.StockRepository;
@Service
public class StockServicelmpl implements IStockSerivce{
	@Autowired 
	StockRepository Sr;
	private static final Logger L =  LogManager.getLogger(StockServicelmpl.class);
	@Override
	public Stock save(Stock stock) {
		// TODO Auto-generated method stub
		return Sr.save(stock);
	}

	
	@Override
	public List<Stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		List<Stock> stocks = (List<Stock>) Sr.findAll();
		for (Stock stock : stocks){
		L.info("stock +++: " + stock );}
		return stocks;
	}
	
	public int ajouterStock(Stock stock) {
		Sr.save(stock);
		return stock.getIdStock();
	}

	@Override
	public void deleteStock(long id) {
		// TODO Auto-generated method stub
Optional<Stock> stk = Sr.findById((int) id);
	    
	    if(stk.isPresent()) 
	        Sr.deleteById((int) id);}

	
	@Override
	public Stock updateStock(Stock stock) {
		// TODO Auto-generated method stub
		return Sr.save(stock);
	}



	@Override
	public List<Stock> OutOfStockDetector(){
		return(List<Stock>)Sr.OutOfStockDetector();
	}
	
	

}
