package pe.egcc.fastfood.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

  private void crearArticuloForm(HttpServletRequest request, HttpServletResponse response) {
  
  } // Fin de crearArticuloForm

  private void crearArticuloSave(HttpServletRequest request, HttpServletResponse response) {
  
  } // Fin de crearArticuloSave
  
  
  
  
  
  
  
} // Fin de ArticuloController
