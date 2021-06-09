package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Cart;
import tn.esprit.spring.entities.Product;
import tn.esprit.spring.repository.CartRepository;
import tn.esprit.spring.repository.IUserRepository;
import tn.esprit.spring.repository.ProductRepository;

import tn.esprit.spring.service.CartService;
import tn.esprit.spring.service.UserService;

@Scope(value = "session")
@Controller(value = "cartController")
@ManagedBean
@SessionScoped
@ELBeanName(value = "cartController") 
@Join(path = "/Cart", to = "/Cart.jsf")

public class CartController {

	@Autowired
	CartService cartService;
	@Autowired
	UserService UserService;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartRepository cartRepository;
	@Autowired
	IUserRepository userRepository;
	private Long id;
	private float montanthors;
	private float montantTTC;
	private float montantTVA;
	private int number;
	private List<Product> produits;
	private String name;
	private Float price;
	private Float total;
	private List<Cart> cart;
	private int quantiteCartClient;
	List<Product> prodIntermediare = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getMontanthors() {
		return montanthors;
	}
	public void setMontanthors(float montanthors) {
		this.montanthors = montanthors;
	}
	public float getMontantTTC() {
		return montantTTC;
	}
	public void setMontantTTC(float montantTTC) {
		this.montantTTC = montantTTC;
	}
	public float getMontantTVA() {
		return montantTVA;
	}
	public void setMontantTVA(float montantTVA) {
		this.montantTVA = montantTVA;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Product> getProduits() {
		return produits;
	}
	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	public List<Cart> getCart() {
	
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	public int getQuantiteCartClient() {
		return quantiteCartClient;
	}
	public void setQuantiteCartClient(int quantiteCartClient) {
		this.quantiteCartClient = quantiteCartClient;
	}	

	public List<Product> getAfficheProductInCart(Long iduser) {
		Cart carts = cartService.SearchCartByUser(iduser);
		return cartRepository.findById(carts.getId()).get().getProduits();
	}
	public String addProductToCart(Long idProduct,Long iduser){
		Cart cart = cartService.SearchCartByUser(iduser);
		cartService.addProductToCart(idProduct, iduser);
		String navigateTo = "";
		FacesMessage facesMessage =

				new FacesMessage("the product have been added to cart successfully");
		FacesContext.getCurrentInstance().addMessage("form:bbbt", facesMessage);
		//navigateTo = "/pages/frontend/productViews/listProductView.xhtml?faces-redirect=true";
		return null;

	}

	public String cartPage() {
		
		String navigateTo = null;
		navigateTo = "/Cart.xhtml?faces-redirect=true";
	
		return navigateTo;
	}

	public Cart searchCartByUser(Long id) {
		return  cartService.SearchCartByUser(id);
		}
	
}
