package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.EmailCfg;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.EventService;
import tn.esprit.spring.service.TwillioService;
import tn.esprit.spring.service.UserService;

@Scope(value = "session")
@Controller(value = "eventController")

@ELBeanName(value = "eventController") // nous permettons d'acceder les
											// variable a partir du code html
											// ex: usereController.Login

@Join(path = "/event", to = "/event.jsf")
public class EventController {
	
	@Autowired
	EventService ES;
	@Autowired
	TwillioService twillioService;
	
	@Autowired
	JavaMailSender mailSender;

	
	
	private String eventname;
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endsdate;
	private long eventIdToBeUpdated;
	
	@Value("${app.twillio.fromPhoneNo}")
	private String from;
	
	@Value("${app.twillio.toPhoneNo}")
	private String to;
	private EmailCfg emailCfg;

	
	private List<Event> events;
	
	// add function 
	public String addevent() {
		String navigateTo = null;
		ES.save(((new Event(eventname, startdate, endsdate ))));
		navigateTo = "/event.xhtml?faces-redirect=true";
		return navigateTo;
	}
	
	// get all events
	
	public List<Event> getEvents() {
		events = ES.retrieveAllEvent();
		return events;
	}
	
	// remove eventss
	
	public String removeEvent(long eventId) {
		String navigateTo = null;
		ES.deleteEvent(eventId);
		navigateTo = "/event.xhtml?faces-redirect=true";
		return navigateTo;
	}
	// dispaly events
	public void displayEvent(Event empl)
	{
	this.setEventname(empl.getEventname());
	this.setStartdate(empl.getStartdate());
	this.setEndsdate(empl.getEndsdate());
	this.setEventIdToBeUpdated(empl.getId());
	}
	// update event
	public void updateEvent()
	{
		ES.updateEvent(new Event(eventIdToBeUpdated, eventname, startdate, endsdate));
		}

	public void sendsms()
	{
		
		String body = "Welcome to our speical event where you can help people";
		twillioService.sendSms(to, from, body);
		
		}
	

	  
	public void sendmail() {
		
		
	 	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	 	mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("anis.ellouz1@esprit.tn");
        mailMessage.setTo("new@event.com");
        mailMessage.setSubject("New Event  ");
        mailMessage.setText("Hello new event is coming soon stay tuned !!");

        // Send mail
        mailSender.send(mailMessage);
		
	
}
	
	
	public EventController(EmailCfg emailCfg) {
		super();
	    this.emailCfg = emailCfg;
		// TODO Auto-generated constructor stub
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEndsdate() {
		return endsdate;
	}

	public void setEndsdate(Date endsdate) {
		this.endsdate = endsdate;
	}
	


	
	public void setEventIdToBeUpdated(Long long1) {
		this.eventIdToBeUpdated = long1;
	}
}
