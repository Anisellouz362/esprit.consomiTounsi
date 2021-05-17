
package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Controller;
@Controller(value = "visitevirtuelcontroller")
@ELBeanName(value = "visitevirtuelcontroller")
@Join(path = "/visitevirtuel", to = "/visitevirtuel.jsf")

public class VisiteVirtuelController {

}
