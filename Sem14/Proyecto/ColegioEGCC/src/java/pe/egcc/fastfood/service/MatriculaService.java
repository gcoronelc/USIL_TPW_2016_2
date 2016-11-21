package pe.egcc.fastfood.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.egcc.fastfood.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class MatriculaService {
  
  public List<Map<String,?>> getSecciones(int periodo){
    List<Map<String,?>> lista;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select IDSECCION, PERIODO, NIVEL, GRADO,"
              + "INGRESO, MATRICULA, NEWCUOTA, OLDCUOTA, "
              + "PISO, AULA, CAPACIDAD, MATRICULADOS "
              + "from v_seccion where periodo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, periodo);
      ResultSet rs = pstm.executeQuery();
      lista = JDBCUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (Exception e) {
      lista = new ArrayList<>();
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;    
  }
  
  
}
