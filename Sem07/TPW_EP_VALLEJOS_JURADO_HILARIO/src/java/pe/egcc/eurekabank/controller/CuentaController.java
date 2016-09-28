package pe.egcc.eurekabank.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.eurekabank.model.Cuenta;
import pe.egcc.eurekabank.service.CuentaService;
import pe.egcc.eurekabank.service.MovimientoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "CuentaController", 
        urlPatterns = {"/CuentaTraerCuenta", "/CuentaCrear"})
public class CuentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/CuentaTraerCuenta")){
      traerCuenta(request,response);
    }
  
  } // Fin de service

  private void traerCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Dato
      String cuenta = request.getParameter("cuenta");
      // Proceso
      CuentaService service;
      service = new CuentaService();
      Cuenta bean = service.traerCuenta(cuenta);
      request.setAttribute("bean", bean);
      MovimientoService movimientoService = new MovimientoService();
      request.setAttribute("movimientos", movimientoService.traerMovimientosPorCuenta(cuenta));
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("conCuenta.jsp");
    rd.forward(request, response);
  }

  
} // Fin de clase
