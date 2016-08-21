package pe.usil.ventaapp.servlets;

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
@WebServlet(name = "VentaServlet", urlPatterns = {"/VentaServlet"})
public class VentaServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
  
    // Recuperar datos
    double precio = Double.parseDouble(request.getParameter("precio"));
    int cant = Integer.parseInt(request.getParameter("cant"));
    // Proceso
    double totalPagar = precio * cant;
    double importe = totalPagar / 1.18;
    double impuesto = totalPagar - importe;
    // Reporte
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>SUMA</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>VENTA</h1>");
    out.println("<p>Precio: " + precio + "</p>");
    out.println("<p>Cantidad: " + cant + "</p>");
    out.println("<p>Importe: " + importe + "</p>");
    out.println("<p>Impuesto: " + impuesto + "</p>");
    out.println("<p>Total: " + totalPagar + "</p>");
    out.println("<a href='index.html'>Otra Venta</a>");
    out.flush();
    out.close();
  }

 
}