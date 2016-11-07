package pe.egcc.fastfood.prueba;

import java.sql.Connection;
import pe.egcc.fastfood.db.AccesoDB;
import pe.egcc.fastfood.model.Empleado;
import pe.egcc.fastfood.service.LogonService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    try {
      Connection cn = AccesoDB.getConnection();
      System.out.println("Conexion ok.");
      cn.close();
      LogonService logonService = new LogonService();
      Empleado bean = logonService.validar("ROXY", "princesa");
      System.out.println("Hola: " + bean.getNombre());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
