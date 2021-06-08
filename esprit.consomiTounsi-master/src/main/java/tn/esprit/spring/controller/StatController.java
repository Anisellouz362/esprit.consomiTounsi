package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ocpsoft.rewrite.annotation.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.statistique.PieChart;
import tn.esprit.spring.service.EventService;
import tn.esprit.spring.service.PubliciteService;



@Controller(value = "statController")
@Join(path = "/stat", to = "/stat.jsf")
@Component
public class StatController {
	@Autowired 
	PubliciteService publiciteService;
	@Autowired
	EventService eventService;

	
	protected List<PieChart> top ;
	protected Map<String, List<PieChart>> event;
	protected List<PieChart> stockold1 ;
	protected List<PieChart> stocknew1 ;
	
	public void getTopPub()
	{
		
		top = new ArrayList<PieChart>();
		List<Object[]> test=publiciteService.getTopPub();
		for(Object[] obj : test){
			top.add(new PieChart(String.valueOf(obj[0]), Integer.valueOf(String.valueOf(obj[1]))));
			
			}	
		
	}
	
	public void statEvent()
	{		
		List<PieChart> nbPlaceDispo = new ArrayList<>();
		List<PieChart> nbParticipant = new ArrayList<>();
		List<Long> name = eventService.getEventList();
		event = new HashMap<>();
		System.out.println(eventService.retrieveAllEvent().size());
		for (Long a : name)			
		{
		nbPlaceDispo.add(new PieChart(eventService.findOne(a).getEventname(),eventService.getNombrePlacesEvent(a)));
		nbParticipant.add(new PieChart(eventService.findOne(a).getEventname(),eventService.getNombreParticpEvent(a)));
		}
		event.put("nbPlaceDispo", nbPlaceDispo);
		event.put("nbParticipant", nbParticipant);				
	}
	
	



	public List<PieChart> getStockold1() {
		return stockold1;
	}

	public void setStockold1(List<PieChart> stockold1) {
		this.stockold1 = stockold1;
	}

	public List<PieChart> getStocknew1() {
		return stocknew1;
	}

	public void setStocknew1(List<PieChart> stocknew1) {
		this.stocknew1 = stocknew1;
	}



	public PubliciteService getPubliciteService() {
		return publiciteService;
	}

	public void setPubliciteService(PubliciteService publiciteService) {
		this.publiciteService = publiciteService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public Map<String, List<PieChart>> getEvent() {
		return event;
	}

	public void setEvent(Map<String, List<PieChart>> event) {
		this.event = event;
	}


	public List<PieChart> getTop() {
		return top;
	}

	public void setTop(List<PieChart> top) {
		this.top = top;
	}

}
