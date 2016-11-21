package pe.egcc.fastfood.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    } else if(path.equals("/LogonSalir")){
      logonSalir(request,response);
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
      // Guardando datos en session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
      
      // Roles
      session.setAttribute("modVentas", 1);
      session.setAttribute("modPlan", 1);
      session.setAttribute("modCon", 1);
      session.setAttribute("modRepo", 0);
      session.setAttribute("modSegu", 1);
      
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

  private void logonSalir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Cerrar session
    HttpSession session = request.getSession();
    session.invalidate();
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
    
  }

  
}
