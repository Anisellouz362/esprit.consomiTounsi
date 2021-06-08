package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Event;

public interface EventService {
	public Event save(Event event);
	
	public List<Long> getEventList();

	List<Event> retrieveAllEvent();
	void deleteEvent(long id);
	Event updateEvent(Event even);
	
	int getNombrePlacesEvent(Long idevent);

	int getNombreParticpEvent(Long idevent);
	
	public Event findOne(long id);

	
	//Contract retrieveContract(long id);
	
}
