package pe.egcc.eurekabank.prueba;

import java.sql.Connection;
import pe.egcc.eurekabank.db.AccesoDB;

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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
