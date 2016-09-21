package pe.egcc.fastfood.prueba;

import java.util.Map;
import pe.egcc.fastfood.service.PedidoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    try {
      PedidoService service = new PedidoService();
      for(Map<String,Object> r: service.traerPedidosPorCliente("C00004")){
        System.out.println(r.get("IdPedido") + " | " + r.get("Total"));
      }
    } catch (Exception e) {
    }
  }  
}
