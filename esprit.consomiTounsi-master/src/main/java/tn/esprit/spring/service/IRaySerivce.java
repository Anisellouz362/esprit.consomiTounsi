package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Ray;


public interface IRaySerivce {
	
	public int ajouterRay(Ray ray);
	public void deleteRay(int RayId);
	public void UpdateRay(int RayId,String RayName, String RayType, String ArranType, int RayCapacity);
	public List<Ray> ShowRay();
	


}
