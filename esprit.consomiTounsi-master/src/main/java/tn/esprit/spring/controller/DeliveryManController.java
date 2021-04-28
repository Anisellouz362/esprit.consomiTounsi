package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Delivery;
import tn.esprit.spring.entities.DeliveryMan;
import tn.esprit.spring.service.IDeliveryManService;

@Controller
public class DeliveryManController {
	@Autowired
	IDeliveryManService ds;
	
	@GetMapping("/get-all-deliveryMan")
	public String getDeliveries(Model model) {
		List<DeliveryMan> list = ds.retrieveAllDeliveryMan();
		model.addAttribute("listDeliveryMan", list);
		return "listDeliveryMan";
	}
	
	
	
	@GetMapping("/get-deliveryMan/{deliveryMan-id}")
	@ResponseBody
	public DeliveryMan getDelivery(@PathVariable("deliveryMan-id") String id) {
		return ds.retrieveDeliveryMan(Long.parseLong(id)).get();
	}
	
	@PostMapping("/add-deliveryMan")
	@ResponseBody
	public void addDelivery(@RequestBody DeliveryMan d) {
	     ds.addDeliveryMan(d);
	}
	
	@DeleteMapping("/remove-deliveryMan/{deliveryMan-id}")
	@ResponseBody
	public void removeDeliveryMan(@PathVariable("deliveryMan-id") String id) {
		ds.deleteDeliveryMan(Long.parseLong(id));
	}
	
	

	
}
