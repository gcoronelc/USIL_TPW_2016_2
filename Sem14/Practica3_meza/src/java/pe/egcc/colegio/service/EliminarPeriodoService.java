package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Periodo;


public class EliminarPeriodoService {

  public void eliminarArticulo(Periodo bean) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      String sql = "delete from periodo where periodo=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getPeriodo());
      pstm.execute();
      pstm.close();
      // Confirmar Tx      
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "Error en la transacción. ";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  public List<Periodo> getPeriodos() {
        List<Periodo> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select periodo, nombre "
                    + "from periodo";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Periodo bean = new Periodo();
                bean.setPeriodo(rs.getInt("periodo"));
                bean.setNombre(rs.getString("nombre"));
                lista.add(bean);
            }
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
        return lista;
    }
  
}
