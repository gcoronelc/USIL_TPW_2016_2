package pe.egcc.colegio.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.colegio.model.Aula;
import pe.egcc.colegio.service.CrearAulaService;
import pe.egcc.colegio.service.ModificarAulaService;
import pe.egcc.colegio.service.EliminarAulaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "MantenimientoAulaController", urlPatterns = {"/CrearAula", "/ModificarAula", "/EliminarAula", "/CargarAulaForm", "/EliminarAulaForm"})
public class AulaController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/CrearAula")){
      crearAula(request,response);
    } else if(path.equals("/ModificarAula")){
      modificarAula(request,response);
    } else if(path.equals("/EliminarAula")){
      eliminarAula(request,response);
    } else if(path.equals("/CargarAulaForm")){
      cargarAulaForm(request,response);
    } else if(path.equals("/EliminarAulaForm")){
      eliminarAulaForm(request,response);
    }
    
  }

  
  
  private void crearAula(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
   
    try {
        Aula bean=new Aula();
        bean.setNombre(request.getParameter("nombre"));
        bean.setPiso(Integer.parseInt(request.getParameter("piso")));
        bean.setNumero(Integer.parseInt(request.getParameter("numero")));
        bean.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
        
        CrearAulaService service=new CrearAulaService();
        service.crearArticulo(bean);
        request.setAttribute("aula", bean.getNombre());
        
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("crearAula.jsp");
    rd.forward(request, response);
  }

  private void modificarAula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    try {
        Aula bean=new Aula();
        bean.setId(Integer.parseInt(request.getParameter("id")));
        bean.setNombre(request.getParameter("nombre"));
        bean.setPiso(Integer.parseInt(request.getParameter("piso")));
        bean.setNumero(Integer.parseInt(request.getParameter("numero")));
        bean.setCapacidad(Integer.parseInt(request.getParameter("capacidad")));
        
        ModificarAulaService service=new ModificarAulaService();
        service.ModificarArticulo(bean);
        request.setAttribute("aula", bean.getId());
        
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("modAula.jsp");
    rd.forward(request, response);
    
  }
  
  private void eliminarAula(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
      
         Aula bean=new Aula();
        bean.setId(Integer.parseInt(request.getParameter("id")));
        
        EliminarAulaService service=new EliminarAulaService();
        service.eliminarArticulo(bean);
        request.setAttribute("aula", bean.getId());
        
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("eliminarAula.jsp");
    rd.forward(request, response);
  }
  
  private void cargarAulaForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    ModificarAulaService service = new ModificarAulaService();
    request.setAttribute("aulas", service.getAulas());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("modAula.jsp");
    rd.forward(request, response);
  }
  
  private void eliminarAulaForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    EliminarAulaService service = new EliminarAulaService();
    request.setAttribute("aulas", service.getAulas());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("eliminarAula.jsp");
    rd.forward(request, response);
  }

  
}
