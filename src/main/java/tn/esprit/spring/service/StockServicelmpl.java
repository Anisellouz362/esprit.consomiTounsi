package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repository.StockRepository;
@Service
public class StockServicelmpl implements IStockSerivce{
	@Autowired 
	StockRepository stockRepository;
	
	
	public int ajouterStock(Stock stock) {
		stockRepository.save(stock);
		return stock.getIdStock();
	}

	
	@Override
	public void deleteStock(int IdStock) {
		stockRepository.deleteById(IdStock);
	}
	
	@Override
	public void UpdateStock(int IdStock,String NameStock, int QuantityStock) {
		Stock stock = stockRepository.findById(IdStock).get();
		stock.setNameStock(NameStock);
		stock.setQuantityStock(QuantityStock);
		stockRepository.save(stock);
	}


	@Override
	public List<Stock> ShowStock() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Stock> ShowStockbyName(String NameStock) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Stock> ShowStockbyQuantity(int QuantityStock) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

	

}
