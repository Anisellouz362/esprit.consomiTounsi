package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.entities.exception.ProduitTounsiException;
import tn.esprit.spring.repository.ProductRepository;



@Service
public class ProductService {
	@Autowired
	  private   ProductRepository repository;
	  
	  @Autowired
	  private static   ProductRepository repository1;
	  

	  
	  public Product saveProduct(Product product){
		return   repository.save(product);
	  }
	  
	  public List<Product> saveProducts (List<Product> products){
	          return repository.saveAll(products);
	        }
	  public List<Product> getProducts(){
		  return repository.findAll();
	  }
	  
	  public  Product getProductsById(int id){
		  return repository.findById(id).orElse(null);
	  }

	 
	  public Product getProductsByName(String name){
		  return repository.findByName(name) ;
	  }
	  
	  public String deleteProduct (int id) {
		  repository.deleteById(id);
		  return "product remove || "+id;
	  }
	  
	  public Product updateProduct (Product product) {
		  Product existingProduct=repository.findById(product.getIdProd()).orElse(null);
			 existingProduct.setName(product.getName());
			 existingProduct.setCategorie(product.getCategorie());
			 try {
				existingProduct.setCodbar(product.getCodbar());
			} catch (ProduitTounsiException e) {
				System.out.print(e.toString());
			}
			 existingProduct.setPrice(product.getPrice());
	         existingProduct.setQte(product.getQte()); 
	       return repository.save(existingProduct)  ;
	  }

	  
	  

}
