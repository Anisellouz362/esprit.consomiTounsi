package tn.esprit.spring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.PublicityRepository;



@Service
public class PublicityService {
	
	@Autowired
	  private PublicityRepository repository;
	  @Autowired
	  private ProductRepository repository1;
	  
	 /* public Publicity savePublicity(Publicity publicity){
		return   repository.save(publicity);
	  }*/
	  
	  public List<Publicity> savePublicitys (List<Publicity> publicitys){
	          return repository.saveAll(publicitys);
	        }
	  public List<Publicity> getPublicitys(){
		  return repository.findAll();
	  }
	  
	  public Publicity getPublicitysById(int id){
		  return repository.findById(id).orElse(null);
	  }
	  
	 
	  public Publicity getPublicitysByName(String name){
		  return repository.findByName(name) ;
	  }
	  
	  public String deletePublicity (int id) {
		  repository.deleteById(id);
		  return "publicity remove || "+id;
	  }
	  
	  public Publicity updatePublicity (Publicity publicity){
		  Publicity existingPublicity=repository.findById(publicity.getIdPub()).orElse(null);
			 existingPublicity.setName(publicity.getName());
			 existingPublicity.setDescription(publicity.getDescription());
			 existingPublicity.setTypepub(publicity.getTypepub());

	       return repository.save(existingPublicity)  ;
	  }
	  public Publicity savePublicity(Publicity publicity) {
		   
		        Publicity newpublicity = new Publicity();
		        newpublicity.setName(publicity.getName());
		        newpublicity.getProducts()
	            .addAll(publicity
	                    .getProducts()
	                    .stream()
	                    .map(v -> {
	                        Product vv = repository1.findByName(v.getName());
	                        vv.getPublicitys().add(newpublicity);
	                        return vv;
	                    }).collect(Collectors.toList()));
		        newpublicity.setDescription(publicity.getDescription());
		        newpublicity.setTypepub(publicity.getTypepub());
		        return repository.save(newpublicity);
	  }

}
