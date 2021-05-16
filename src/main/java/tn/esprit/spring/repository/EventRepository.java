package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Event;
@Repository
public interface EventRepository  extends CrudRepository<Event,Long>{
	@Query(value = "SELECT e.nbplace FROM event as e WHERE e.id=?1", nativeQuery = true)
	public int NombrePlacesEvent(Long idevent);
	@Query(value = "SELECT e.nbparticipant FROM event as e WHERE e.id=?1", nativeQuery = true)
	public int NombreParticpEvent(Long idevent);
	@Query(value = "SELECT DISTINCT e.id FROM event as e", nativeQuery = true)
	public List<Long> EventList();

}
