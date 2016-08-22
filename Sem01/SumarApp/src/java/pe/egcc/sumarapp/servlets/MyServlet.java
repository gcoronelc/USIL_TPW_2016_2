package pe.egcc.sumarapp.servlets;

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
@WebServlet(name = "MyServlet", urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    // Datos
    int n1 = Integer.parseInt(request.getParameter("num1"));
    int n2 = Integer.parseInt(request.getParameter("num2"));
    // Proceso
    int suma = n1 + n2;
    // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMA</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>SUMA</h1>");
    out.println("<p>Número 1: " + n1 + "</p>");
    out.println("<p>Número 2: " + n2 + "</p>");
    out.println("<p>Suma: " + suma + "</p>");
    out.println("<a href='index.html'>Volver</a>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doGet(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMA</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<p>Debes usar el formulario.</p>");
    out.println("<a href='index.html'>Ir al formulario</a>");
    out.println("</body>");
    out.println("</html>");
  }

  
  
}
