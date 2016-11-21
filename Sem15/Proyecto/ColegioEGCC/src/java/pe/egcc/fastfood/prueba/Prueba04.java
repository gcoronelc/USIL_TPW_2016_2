package pe.egcc.fastfood.prueba;

import pe.egcc.fastfood.service.SeguridadService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba04 {
  
  public static void main(String[] args) {
    try {
      // Dato
      int idemp = 3;
      String[] modulos = {"VEN","PLA","REP","SEG"};
      // Proceso
      SeguridadService service = new SeguridadService();
      for (String mod : modulos) {
        int permiso = service.getPermiso(idemp, mod);
        System.out.println(mod + ": " + permiso);
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
