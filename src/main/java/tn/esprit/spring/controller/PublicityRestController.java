package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Publicity;

import tn.esprit.spring.service.PublicityService;



@RestController
public class PublicityRestController {
	@Autowired
	private PublicityService Service;

	
	
	@PostMapping("/addPublicity")
	public Publicity addPublicity(@RequestBody Publicity publicity){
		return Service.savePublicity(publicity);
	}

	@PostMapping("/addPublicitys")
	public List<Publicity> addPublicitys(@RequestBody List<Publicity> publicitys){
		return Service.savePublicitys(publicitys);
	}


	@GetMapping("/publicity/")
	public List<Publicity> findAllPublicitys(){
		return Service.getPublicitys();
	}
	@GetMapping("/publicity/{id}")
	public Publicity findPublicityById(@PathVariable int id){
		return Service.getPublicitysById(id);
	}
	@GetMapping("/publicitys/{name}")
	public Publicity findPublicityByName(@PathVariable String name){
		return Service.getPublicitysByName(name);
	}

	@PutMapping("/updatePublicity")
	public Publicity updatePublicity(@RequestBody Publicity publicity) {
		return Service.updatePublicity(publicity);
	}

	@DeleteMapping("/deletePublicity/{id}")
	public String deletePublicity(@PathVariable int id) {
		return Service.deletePublicity(id);
	}
	

}
