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

import tn.esprit.spring.entities.Product;
import tn.esprit.spring.service.ProductService;




@RestController
public class ProductRestController {
	


	
	@Autowired
	private ProductService service;
	
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	
	@GetMapping("/product/")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id){
		return service.getProductsById(id);
	}
	@GetMapping("/products/{name}")
	public Product findProductByName(@PathVariable String name){
		return service.getProductsByName(name);
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

}
