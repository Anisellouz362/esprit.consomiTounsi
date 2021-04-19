package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.service.BillService;

@RestController
@RequestMapping("/Bill")
public class BillRestController {
	@Autowired
	BillService Sr;
	// http://localhost:8081/SpringMVC/servlet/Bill/add-facture
				@PostMapping("/add-facture")
				@ResponseBody
				public Facture saveBill(@RequestBody Facture fact) {
				Facture facture = Sr.save(fact);
				return facture;
				}
				
				// URL : http://localhost:8081/SpringMVC/servlet/Bill/getAllBill
			    @GetMapping(value = "getAllBill")
			  
			    public List<Facture> getAllBill() {
					List<Facture> list = Sr.getAllBill();
					return list;
				}
			    
			    
			    // URL : http://localhost:8081/SpringMVC/servlet/Bill/delete-bill
				   @DeleteMapping(value = "delete-bill/{id}")
				   
					public void deleteBill(@PathVariable("id")Long id){
					   Sr.deleteBill(id);
				   }
				   
					// http://localhost:8081/SpringMVC/servlet/Bill/modify-bill
					@PutMapping("/modify-bill")
					@ResponseBody
					public Facture modifyBill(@RequestBody Facture facture) {
					return Sr.updateBill(facture);
			    

}}
