package tn.esprit.spring.controller;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Controller;
@Controller(value = "eventclientcontroller")
@ELBeanName(value = "eventclientcontroller")
@Join(path = "/eventclient", to = "/eventclient.jsf")

public class EventclientController {

}
