package pe.egcc.tpw_pc2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.tpw_pc2.model.Combo;
import pe.egcc.tpw_pc2.model.Empleado;
import pe.egcc.tpw_pc2.service.ComboService;
import pe.egcc.tpw_pc2.service.EmpleadoService;

@Controller
public class HomeController {
  
  @Autowired
  private EmpleadoService empleadoService;
  
  @Autowired
  private ComboService comboService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
	  List<Combo> departamentos = comboService.getDepartamentos();
	  model.addAttribute("departamentos", departamentos);
		return "home";
	}
	
	
	@RequestMapping(value = "/ConsultarEmpleados.htm", method = RequestMethod.POST)
  public String consultar(@RequestParam("dpto") int dpto, Model model) {
	  List<Empleado> lista = empleadoService.consEmpleados(dpto);
	  model.addAttribute("lista", lista);
	  model.addAttribute("departamentos", comboService.getDepartamentos());
    return "home";
  }
	
	@RequestMapping(value="/crearUsuario.htm", method=RequestMethod.GET)
	public String crearUsuario(@RequestParam("id") String id, Model model){
	  
	  return "crearUsuario";
	}
}
