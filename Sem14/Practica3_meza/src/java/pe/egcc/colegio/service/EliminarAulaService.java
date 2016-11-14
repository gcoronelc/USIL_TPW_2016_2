package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Aula;


public class EliminarAulaService {

  public void eliminarArticulo(Aula bean) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      String sql = "delete from seccion where idaula=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getId());
      pstm.execute();
      pstm.close();
      
      sql = "delete from aula where idaula=?";
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getId());
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
  
   public List<Aula> getAulas() {
        List<Aula> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idaula, nombre "
                    + "from aula";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Aula bean = new Aula();
                bean.setId(rs.getInt("idaula"));
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
