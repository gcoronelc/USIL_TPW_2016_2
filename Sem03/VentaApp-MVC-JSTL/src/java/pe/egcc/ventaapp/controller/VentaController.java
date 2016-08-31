package pe.egcc.ventaapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.ventaapp.model.VentaModel;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Datos
    VentaModel model = new VentaModel();
    model.setPrecio(Double.parseDouble(request.getParameter("precio")));
    model.setCant(Integer.parseInt(request.getParameter("cant")));
    // Proceso
    VentaService service = new VentaService();
    service.procesar(model);
    // Forward
    request.setAttribute("model", model);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("venta.jsp");
    rd.forward(request, response);
  }
  
}