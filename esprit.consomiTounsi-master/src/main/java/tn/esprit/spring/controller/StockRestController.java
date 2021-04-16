package tn.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.service.IStockSerivce;

@RestController
public class StockRestController {
	@Autowired
	IStockSerivce iStockService;
	
	// http://localhost:8081/SpringMVC/servlet/ajouterStock
	@PostMapping("/ajouterStock")
	@ResponseBody
	public Stock ajouterStock(@RequestBody Stock stock) {
		iStockService.ajouterStock(stock);
		return stock;
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/deleteStock/{IDSTOCK}
	 @DeleteMapping("/deleteStock/{IdStock}") 
	 @ResponseBody
	public void deleteStock(@PathVariable("IdStock")int IdStock){
		 iStockService.deleteStock(IdStock);
	 }
	 
//	// http://localhost:8081/SpringMVC/servlet/mettreAjourStock/{IdStock}/{newstock}
//		 @PutMapping("/mettreAjourStock/{id}/{newetat}") 
//		 @ResponseBody
//		 public void mettreAjourStock(@PathVariable("newetat") String etat, @PathVariable("id") int IdStock){
//			 iStockService.mettreAjourLivraison(IdStock, etat);
//		 }
	 
	 
		// http://localhost:8081/SpringMVC/servlet/ShowStock
	 @GetMapping(value = "ShowStock") 
	 
	 public List<Stock> ShowStock(){
		   return iStockService.ShowStock();
	 }
	 
	 
		// http://localhost:8081/SpringMVC/servlet/ShowStockbyName/{STOCKNAME}
	 @GetMapping(value = "ShowStockbyName/{stockName}") 
	 public List<Stock> ShowStockbyName(@PathVariable("stockName") String stockName){
	 return iStockService.ShowStockbyName(stockName);
	 }
	 
		// http://localhost:8081/SpringMVC/servlet/ShowStockbyQuantity/{STOCKQuantity}
	 @GetMapping(value = "ShowStockbyQuantity/{QuantityStock}") 
	 public List<Stock> ShowStockbyQuantity(@PathVariable("QuantityStock") int QuantityStock){
     return iStockService.ShowStockbyQuantity(QuantityStock);
	 }
	 

	
	 
	 
	 

}