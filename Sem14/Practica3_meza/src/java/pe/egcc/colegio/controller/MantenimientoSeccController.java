package pe.egcc.colegio.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.colegio.model.Seccion;
import pe.egcc.colegio.service.CrearSeccionService;
import pe.egcc.colegio.service.ModificarSeccionService;
import pe.egcc.colegio.service.EliminarSeccionService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "MantenimientoSeccionController", urlPatterns = {"/CargarSeccionForm", "/CrearSeccion", "/ModificarSeccion", "/EliminarSeccion", "/ModificarSeccionForm", "/EliminarSeccionForm"})
public class MantenimientoSeccController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/CargarSeccionForm")){
      cargarSeccionForm(request,response);
    } else if(path.equals("/CrearSeccion")){
      crearSeccion(request,response);
    } else if(path.equals("/ModificarSeccion")){
      modificarSeccion(request,response);
    } else if(path.equals("/EliminarSeccion")){
      eliminarSeccion(request,response);
    } else if(path.equals("/ModificarSeccionForm")){
      modificarSeccionForm(request,response);
    } else if(path.equals("/EliminarSeccionForm")){
      eliminarSeccionForm(request,response);
    }
    
  }
  
   private void cargarSeccionForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    CrearSeccionService service = new CrearSeccionService();
    request.setAttribute("niveles", service.getNiveles());
    request.setAttribute("aulas", service.getAulas());
    request.setAttribute("periodos", service.getPeriodos());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("crearSeccion.jsp");
    rd.forward(request, response);
  }
  
  private void crearSeccion(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    
    try {
      
        Seccion bean=new Seccion();
        
        bean.setIdNiv(Integer.parseInt(request.getParameter("nivel")));
        bean.setIdGra(Integer.parseInt(request.getParameter("grado")));
        bean.setIdAul(Integer.parseInt(request.getParameter("aula")));
        bean.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
        
        CrearSeccionService service=new CrearSeccionService();
        service.crearArticulo(bean);
        request.setAttribute("secciones", bean.getPeriodo());
        
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("crearSeccion.jsp");
    rd.forward(request, response);
  }

  private void modificarSeccion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
       try {
      
        Seccion bean=new Seccion();
        bean.setIdSec(Integer.parseInt(request.getParameter("id")));
        bean.setIdNiv(Integer.parseInt(request.getParameter("nivel")));
        bean.setIdGra(Integer.parseInt(request.getParameter("grado")));
        bean.setIdAul(Integer.parseInt(request.getParameter("aula")));
        bean.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
        
        ModificarSeccionService service=new ModificarSeccionService();
        service.modificarArticulo(bean);
        request.setAttribute("seccion", bean.getIdSec());
        
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("modSeccion.jsp");
    rd.forward(request, response);
    
  }
  
  private void eliminarSeccion(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
        
        Seccion bean=new Seccion();
        bean.setIdSec(Integer.parseInt(request.getParameter("id")));
    
        EliminarSeccionService service=new EliminarSeccionService();
        service.eliminarArticulo(bean);
        request.setAttribute("seccion", bean.getIdSec());
      
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("eliminarSeccion.jsp");
    rd.forward(request, response);
  }
  
  private void modificarSeccionForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    ModificarSeccionService service = new ModificarSeccionService();
    request.setAttribute("secciones", service.getSecciones());
    request.setAttribute("niveles", service.getNiveles());
    request.setAttribute("aulas", service.getAulas());
    request.setAttribute("periodos", service.getPeriodos());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("modSeccion.jsp");
    rd.forward(request, response);
  }
  
  private void eliminarSeccionForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    EliminarSeccionService service = new EliminarSeccionService();
    request.setAttribute("secciones", service.getSecciones());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("eliminarSeccion.jsp");
    rd.forward(request, response);
  }
  
}
