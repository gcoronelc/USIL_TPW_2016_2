package pe.egcc.demojdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.egcc.demojdbc.service.CuentaService;

@Controller
public class HomeController {

  @Autowired
  private CuentaService cuentaService;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "home";
  }

  @RequestMapping(value="/saldoForm.htm", method=RequestMethod.GET)
  public String saldoForm(){
    return "saldo";
  }
  
  @RequestMapping(value="/cuentaProcesar.htm", method=RequestMethod.POST)
  public String saldoForm(
      @RequestParam("cuenta") String cuenta, Model model){
    
    model.addAttribute("cuenta", cuenta);
    try {
      double saldo = cuentaService.obtenerSaldo(cuenta);
      model.addAttribute("saldo", saldo);
    } catch (Exception e) {
      model.addAttribute("error", e.getMessage());
    }
    return "saldo";
  }
}
