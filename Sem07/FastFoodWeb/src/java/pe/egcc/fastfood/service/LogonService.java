package pe.egcc.fastfood.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.fastfood.db.AccesoDB;
import pe.egcc.fastfood.model.Empleado;

public class LogonService {

  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idEmpleado, ApeEmpleado, "
              + "NomEmpleado, DirEmpleado, TelEmpleado "
              + "from empleado "
              + "where idEmpleado = ? "
              + "and Clave = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Empleado();
        bean.setId(rs.getString("idEmpleado"));
        bean.setApellido(rs.getString("ApeEmpleado"));
        bean.setNombre(rs.getString("NomEmpleado"));
        bean.setDireccion(rs.getString("DirEmpleado"));
        bean.setTelefono(rs.getString("TelEmpleado"));
        bean.setClave("********");
      }
      rs.close();
      pstm.close();
      if(bean == null){
        throw new Exception("Datos incorrectos.");
      }
    } catch (Exception e) {
      throw  new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

}
