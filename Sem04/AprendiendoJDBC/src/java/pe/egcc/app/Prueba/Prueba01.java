package pe.egcc.app.Prueba;

import java.sql.Connection;
import java.sql.DriverManager;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://172.17.19.251:3306/fastfood";
    String user = "fastfood";
    String pass = "admin";
    try {
      // Cargar el driver
      Class.forName(driver).newInstance();
      // Obtener la conexión
      Connection cn = DriverManager.getConnection(urlDB, user, pass);
      System.out.println("Conexión ok");
      cn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
