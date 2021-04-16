package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Ray;
import tn.esprit.spring.service.IRaySerivce;

@RestController
public class RayRestController {
	@Autowired
	IRaySerivce iRayService;
	
	//http://localhost:8081/SpringMVC/servlet/ajouterRay
	@PostMapping("/ajouterRay")
	@ResponseBody
	public Ray ajouterRay(@RequestBody Ray ray) {
		iRayService.ajouterRay(ray);
		return ray;
	}
	
	
	// http://localhost:8081/SpringMVC/servlet/deleteRay/{RayId}
	 @DeleteMapping("/deleteRay/{RayId}") 
	 @ResponseBody
	public void deleteRay(@PathVariable("RayId")int RayId){
		 iRayService.deleteRay(RayId);
	 }
	 
	// http://localhost:8081/SpringMVC/servlet/UpdateRay/{RayId}/{newray}
		 @PutMapping("/UpdateRay/{id}/{newetat}") 
		 @ResponseBody
		 public void UpdateRay(@PathVariable("RayId") int RayId, @PathVariable("RayName") String RayName, @PathVariable("RayType") String RayType, @PathVariable("ArranType") String ArranType, @PathVariable("RayCapacity") int RayCapacity){
			 iRayService.UpdateRay(RayId, RayName, RayType, ArranType, RayCapacity);
		 }

}

