package pe.egcc.fastfood.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public final class AccesoDB {

  private AccesoDB() {
  }
  
  public static Connection getConnection() throws SQLException{
    // Parámetros
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://172.17.19.205:3306/colegio";
    String user = "colegio";
    String pass = "admin";
    // Variable
    Connection cn = null;
    // Proceso
    try {
      // Cargar el driver
      Class.forName(driver).newInstance();
      // Obtener la conexión
      cn = DriverManager.getConnection(urlDB, user, pass);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se ha encontrado el driver de BD.");
    } catch(SQLException e){
      throw e;
    } catch(Exception e){
      throw new SQLException("No se tiene acceso al servidor de BD.");
    }
    // Retorno
    return cn;
  }
  
}
