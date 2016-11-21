package pe.egcc.fastfood.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import pe.egcc.fastfood.db.AccesoDB;
import pe.egcc.fastfood.model.Matricula;
import pe.egcc.fastfood.util.JdbcUtil;

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
      sql = "insert into pago(idmat,idtipo,empgenpago,"
              + "empregpago,fecvenc,fecpago,importe,"
              + "mora,total,pendiente) "
              + "values(?,1,?,?,sysdate(),sysdate(),?,?,?,0)";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, idmat);
      pstm.setInt(2, bean.getIdemp());
      pstm.setInt(3, bean.getIdemp());
      pstm.setDouble(4, bean.getImporte());
      pstm.setDouble(5, 0.0);
      pstm.setDouble(6, bean.getImporte());
      pstm.executeUpdate();
      pstm.close();
      // Confirmar transacciòn
      cn.commit();
      // Fin
      bean.setIdmat(idmat);
    } catch (Exception e) {
      try {
        // Cancela la Transacción
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  public List<Map<String, ?>> getEstudiantesIngreso() {
    List<Map<String, ?>> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idest, concat(apellido,', ',nombre) nombre "
              + "from estudiante "
              + "where idest not in ( "
              + "select distinct idest from matricula)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      lista = JdbcUtil.rsToList(rs);
      rs.close();
      pstm.close();
    } catch (Exception e) {
      e.printStackTrace();
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
