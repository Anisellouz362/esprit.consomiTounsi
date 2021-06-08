package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Controller;
@Controller(value = "visitevirtuellecontroller")
@ELBeanName(value = "visitevirtuellecontroller")
@Join(path = "/visitevirtuelle", to = "/visitevirtuelle.jsf")

public class VisiteVirtuelleController {

}
