package pe.egcc.tpw_pc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.tpw_pc2.model.Empleado;
import pe.egcc.tpw_pc2.service.EmpleadoService;

@Controller
public class HomeController {
  
  @Autowired
  private EmpleadoService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "home";
	}
	
	
	@RequestMapping(value = "/ConsultarEmpleados.htm", method = RequestMethod.POST)
  public String consultar(@RequestParam("dpto") int dpto, Model model) {
	  List<Empleado> lista = service.consEmpleados(dpto);
	  model.addAttribute("lista", lista);
    return "home";
  }
	
	
}
