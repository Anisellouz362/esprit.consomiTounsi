package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Reclamations;
import tn.esprit.spring.service.ClientService;
import tn.esprit.spring.service.ReclamationService;

@RestController
public class ReclamationController {

	@Autowired
	ReclamationService rs;
	
	@Autowired
	ClientService cs;
	
	
	

	@PostMapping("/ajouterReclamation/{client-id}")
	@ResponseBody
	public Reclamations ajouterReclamation(@RequestBody Reclamations r,@PathVariable("client-id") String idClient)
	{
		Client c = cs.retrieveClient(Long.parseLong(idClient)).get();
		r.setClient(c);
		rs.addReclamation(r);
		return r;
	}
	
	
	@GetMapping("/retrieve-all-reclamations")
	 @ResponseBody
	 public List<Reclamations> getReclamation() {
	 List<Reclamations> list = rs.retrieveAllReclamations();
	 return list;
	 }

	
	
	
			 @GetMapping("/retrieve-reclamation/{reclamation-id}")
			 @ResponseBody
			 public Optional<Reclamations> retrievereclamation(@PathVariable("reclamation-id") String reclamationId) {
			 
				 
				 
				 return rs.retrieveReclamation(Long.parseLong(reclamationId))  ;
			 }

			   @DeleteMapping("/remove-reclamation/{reclamation-id}")
			   @ResponseBody
			   public void removereclamation(@PathVariable("reclamation-id") String id) {
			   rs.deleteReclamation(Long.parseLong(id));
			   }


			   @PutMapping("/modify-reclamation/{client-id}")
			    @ResponseBody
			    public void modifyreclamation(@RequestBody Reclamations r,@PathVariable("client-id") String idClient) {
				   Client c = cs.retrieveClient(Long.parseLong(idClient)).get();
				   r.setClient(c);
			     rs.updateReclamation(r);
			    }
			   
			   
			
	
	
	
}
