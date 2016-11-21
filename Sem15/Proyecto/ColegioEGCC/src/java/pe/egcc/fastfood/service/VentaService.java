package pe.egcc.fastfood.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.fastfood.db.AccesoDB;
import pe.egcc.fastfood.model.Matricula;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class VentaService {

  public void regIngreso(Matricula bean) {
    Connection cn = null;
    try {
      // El objeto Connection
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Verificar que matricula no exista
      String sql = "select count(*) cont from matricula "
              + "where idest=? and idseccion=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getIdest());
      pstm.setInt(2, bean.getIdseccion());
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if (cont > 0) {
        throw new Exception("Estudiante ya esta matriculado.");
      }
      // Registrar matricula
      sql = "insert into matricula(idemp,idest,idseccion,fecha,estado) "
              + "values(?,?,?,sysdate(),0)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getIdemp());
      pstm.setInt(2, bean.getIdest());
      pstm.setInt(3, bean.getIdseccion());
      pstm.executeUpdate();
      pstm.close();
      // Leer el id de matricula
      sql = "select last_insert_id() id";
      pstm = cn.prepareStatement(sql);
      rs = pstm.executeQuery();
      rs.next();
      int idmat = rs.getInt("id");
      rs.close();
      pstm.close();
      // Registrar Pago
      sql = "";
      
    } catch (Exception e) {

    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
