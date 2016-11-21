package pe.egcc.fastfood.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.fastfood.model.Articulo;
import pe.egcc.fastfood.service.ArticuloService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "ArticuloController", 
        urlPatterns = {"/CrearArticuloForm","/CrearArticuloSave"})
public class ArticuloController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
  
    String path = request.getServletPath();
    switch(path){
      case "/CrearArticuloForm":
        crearArticuloForm(request,response);
        break;
      case "/CrearArticuloSave":
        crearArticuloSave(request,response);
        break;
    }
    
  } // service

  private void crearArticuloForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    // Proceso
    ArticuloService service = new ArticuloService();
    request.setAttribute("categorias", service.getCategorias());
    // Forware
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("crearArticulo.jsp");
    rd.forward(request, response);
  } // Fin de crearArticuloForm

  private void crearArticuloSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
    try {
      // Datos
      Articulo art = new Articulo();
      art.setIdCat(Integer.parseInt(request.getParameter("cat")));
      art.setNombre(request.getParameter("nombre"));
      art.setPrecio(Double.parseDouble(request.getParameter("precio")));
      // Proceso
      ArticuloService service = new ArticuloService();
      service.crearArticulo(art);
      request.setAttribute("codigo", art.getId());
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("crearArticulo.jsp");
    rd.forward(request, response);
  } // Fin de crearArticuloSave
  
  
  
  
  
  
  
} // Fin de ArticuloController
