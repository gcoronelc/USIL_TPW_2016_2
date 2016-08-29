package pe.usil.mateapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.usil.mateapp.model.MateModel;
import pe.usil.mateapp.service.MateService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "MateController",
        urlPatterns = {"/SumaController", "/RestaController",
          "/MultiplicaController","/DividirController"})
public class MateController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if (path.equals("/SumaController")) {
      sumaController(request, response);
    } else if (path.equals("/RestaController")) {
      restaController(request, response);
    } else if (path.equals("/MultiplicaController")) {
      multiplicaController(request, response);
    }
  }

  private void sumaController(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    // Proceso
    MateModel model = new MateModel("S", n1, n2);
    MateService service = new MateService();
    service.procesar(model);
    // Datos para el JSP
    request.setAttribute("model", model);
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("sumar.jsp");
    rd.forward(request, response);
  }

  private void restaController(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void multiplicaController(HttpServletRequest request, HttpServletResponse response) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
