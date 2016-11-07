package pe.egcc.fastfood.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.fastfood.model.Cliente;
import pe.egcc.fastfood.service.ClienteService;
import pe.egcc.fastfood.service.PedidoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "ClienteController", 
        urlPatterns = {"/ClienteTraerCliente", "/ClienteCrear"})
public class ClienteController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/ClienteTraerCliente")){
      traerCliente(request,response);
    }
  
  } // Fin de service

  private void traerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Dato
      String codigo = request.getParameter("codigo");
      // Proceso
      ClienteService service;
      service = new ClienteService();
      Cliente bean = service.traerCliente(codigo);
      request.setAttribute("bean", bean);
      PedidoService pedidoService = new PedidoService();
      request.setAttribute("pedidos", pedidoService.traerPedidosPorCliente(codigo));
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("conClientes.jsp");
    rd.forward(request, response);
  }

  
} // Fin de clase
