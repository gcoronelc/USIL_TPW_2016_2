package pe.egcc.fastfood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.fastfood.service.VentaService;

@WebServlet(name = "VentaController", 
        urlPatterns = {"/VentaGetProIngreso", "/ssss", "/ssssss"})
public class VentaController extends HttpServlet {

  private VentaService ventaService;

  @Override
  public void init() throws ServletException {
    ventaService = new VentaService();
  }
  
  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    switch(request.getServletPath()){
      case "/VentaGetProIngreso":
        getProIngreso(request,response);
        break;
    }
  } // Fin de service

  private void getProIngreso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      List<Map<String,?>> lista = ventaService.getEstudiantesIngreso();
      request.setAttribute("listaEst", lista);
    } catch (Exception e) {
    }
    // Forward
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("procIngreso.jsp");
    rd.forward(request, response);
  }

} // Fin de VentaController
