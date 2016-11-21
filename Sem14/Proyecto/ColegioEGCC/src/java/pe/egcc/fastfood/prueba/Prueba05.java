package pe.egcc.fastfood.prueba;

import java.util.List;
import java.util.Map;
import pe.egcc.fastfood.service.MatriculaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba05 {
  
  public static void main(String[] args) {
    try {
      MatriculaService service = new MatriculaService();
      List<Map<String,?>> lista = service.getSecciones(2016);
      for (Map<String, ?> r : lista) {
        System.out.println(r.get("IDSECCION") + " | " + 
                r.get("AULA"));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
