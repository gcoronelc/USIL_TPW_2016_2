package pe.egcc.fastfood.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.fastfood.model.Empleado;
import pe.egcc.fastfood.service.LogonService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "LogonController", urlPatterns = {"/LogonIngreso", "/LogonSalir"})
public class LogonController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/LogonIngreso")){
      logonIngreso(request,response);
    }
    
  }

  private void logonIngreso(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    String destino = "";
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      LogonService service = new LogonService();
      Empleado bean = service.validar(usuario, clave);
      destino = "main.jsp";
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  
}
