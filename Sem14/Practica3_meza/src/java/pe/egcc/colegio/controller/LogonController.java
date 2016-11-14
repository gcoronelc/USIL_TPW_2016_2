package pe.egcc.colegio.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.colegio.model.Empleado;
import pe.egcc.colegio.service.LogonService;
import pe.egcc.colegio.service.SeguridadService;

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
      
      String[] modulos = {"VEN","PLA","REP","SEG"};
      // Proceso
      SeguridadService rol = new SeguridadService();
      for (String mod : modulos) {
        int permiso = rol.getPermiso(bean.getIdemp(), mod);
        // Roles
      session.setAttribute(mod, permiso);
      }
      
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
