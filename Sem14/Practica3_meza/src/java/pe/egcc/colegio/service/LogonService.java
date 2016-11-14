package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Empleado;

public class LogonService {

  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Verificar usuario y clave
      String sql = "select idemp from usuario "
              + "where usuario=? and clave=SHA(?) and estado=1";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new Exception("Datos incorrectos.");
      }
      int idemp = rs.getInt("idemp");
      rs.close();
      pstm.close();
      // Datos del empleado
      sql = "select idemp, nombre, apellido, dni,"
              + "direccion, telefono, correo, estado "
              + "from empleado where idemp = ? and estado = 1";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idemp);
      rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new Exception("Usuario no autorizado.");
      }
      bean = new Empleado();
      bean.setIdemp(rs.getInt("idemp"));
      bean.setNombre(rs.getString("nombre"));
      bean.setApellido(rs.getString("apellido"));
      bean.setDni(rs.getString("dni"));
      bean.setDireccion(rs.getString("direccion"));
      bean.setTelefono(rs.getString("telefono"));
      bean.setCorreo(rs.getString("correo"));
      bean.setEstado(rs.getInt("estado"));
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

}
