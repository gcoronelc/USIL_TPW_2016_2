package pe.egcc.colegio.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.colegio.model.Periodo;
import pe.egcc.colegio.service.CrearPeriodoService;
import pe.egcc.colegio.service.ModificarPeriodoService;
import pe.egcc.colegio.service.EliminarPeriodoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "MantenimientoPeriodoController", urlPatterns = {"/CrearPeriodo", "/ModificarPeriodo", "/EliminarPeriodo", "/CargarPeriodoForm", "/EliminarPeriodoForm"})
public class PeriodoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/CrearPeriodo")){
      crearPeriodo(request,response);
    } else if(path.equals("/ModificarPeriodo")){
      modificarPeriodo(request,response);
    } else if(path.equals("/EliminarPeriodo")){
      eliminarPeriodo(request,response);
    }else if(path.equals("/CargarPeriodoForm")){
      cargarPeriodoForm(request,response);
    }else if(path.equals("/EliminarPeriodoForm")){
      eliminarPeriodoForm(request,response);
    }
    
    
  }

  private void crearPeriodo(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
      
        Periodo bean=new Periodo();
        bean.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
        bean.setNombre(request.getParameter("nombre"));
        bean.setIngreso(Integer.parseInt(request.getParameter("ingreso")));
        bean.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        bean.setCuota_new(Integer.parseInt(request.getParameter("cuotanew")));
        bean.setCuota_old(Integer.parseInt(request.getParameter("cuotaold")));
        bean.setMora(Integer.parseInt(request.getParameter("mora")));
        bean.setHoIng(request.getParameter("horaIng"));
        bean.setHoSalida(request.getParameter("horaSal"));
        
        CrearPeriodoService service=new CrearPeriodoService();
        service.crearArticulo(bean);
        request.setAttribute("periodo", bean.getPeriodo());
        
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("crearPeriodo.jsp");
    rd.forward(request, response);
  }

  private void modificarPeriodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   try {
      
        Periodo bean=new Periodo();
        bean.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
        bean.setNombre(request.getParameter("nombre"));
        bean.setIngreso(Integer.parseInt(request.getParameter("ingreso")));
        bean.setMatricula(Integer.parseInt(request.getParameter("matricula")));
        bean.setCuota_new(Integer.parseInt(request.getParameter("cuotanew")));
        bean.setCuota_old(Integer.parseInt(request.getParameter("cuotaold")));
        bean.setMora(Integer.parseInt(request.getParameter("mora")));
        bean.setHoIng(request.getParameter("horaIng"));
        bean.setHoSalida(request.getParameter("horaSal"));
        
        ModificarPeriodoService service=new ModificarPeriodoService();
        service.modificarArticulo(bean);
        request.setAttribute("periodo", bean.getPeriodo());
        
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("modPeriodo.jsp");
    rd.forward(request, response);
  }
  
  private void eliminarPeriodo(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
        
        Periodo bean=new Periodo();
        bean.setPeriodo(Integer.parseInt(request.getParameter("periodo")));
        
        EliminarPeriodoService service=new EliminarPeriodoService();
        service.eliminarArticulo(bean);
        request.setAttribute("periodo", bean.getPeriodo());
      
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("eliminarPeriodo.jsp");
    rd.forward(request, response);
  }
  
  private void cargarPeriodoForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    ModificarPeriodoService service = new ModificarPeriodoService();
    request.setAttribute("periodos", service.getPeriodos());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("modPeriodo.jsp");
    rd.forward(request, response);
  }
  
  private void eliminarPeriodoForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    EliminarPeriodoService service = new EliminarPeriodoService();
    request.setAttribute("periodos", service.getPeriodos());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("eliminarPeriodo.jsp");
    rd.forward(request, response);
  }
  
}
