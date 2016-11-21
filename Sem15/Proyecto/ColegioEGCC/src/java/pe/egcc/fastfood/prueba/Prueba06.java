package pe.egcc.fastfood.prueba;

import java.util.Map;
import pe.egcc.fastfood.service.VentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba06 {
  public static void main(String[] args) {
    try {
      VentaService service = new VentaService();
      for (Map<String,?> r: service.getEstudiantesIngreso()) {
        System.out.println(r.get("IDEST") + " - " + r.get("NOMBRE"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
