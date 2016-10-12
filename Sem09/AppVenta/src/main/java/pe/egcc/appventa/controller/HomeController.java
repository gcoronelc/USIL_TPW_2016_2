package pe.egcc.appventa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.egcc.appventa.model.Venta;
import pe.egcc.appventa.service.VentaService;


@Controller
public class HomeController {
  
  @Autowired
  private VentaService ventaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="venta.papo", method=RequestMethod.POST)
	public String procesar(@ModelAttribute Venta bean, Model model){
	  // Proceso
	  ventaService.procesar(bean);
	  // Reporte
	  model.addAttribute("venta", bean);
	  // Forward
	  return "resultado";
	}
	
	
}
