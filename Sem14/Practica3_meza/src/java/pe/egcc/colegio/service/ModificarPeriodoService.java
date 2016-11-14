package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Periodo;


public class ModificarPeriodoService {

  public void modificarArticulo(Periodo bean) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      String sql = "update periodo set  NOMBRE=?, INGRESO=?, MATRICULA=?, CUOTA_NEW=?, CUOTA_OLD=?, MORA=?, HINGRESO=?, HSALIDA=? where periodo=?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getNombre());
      pstm.setDouble(2, bean.getIngreso());
      pstm.setDouble(3, bean.getMatricula());
      pstm.setDouble(4, bean.getCuota_new());
      pstm.setDouble(5, bean.getCuota_old());
      pstm.setDouble(6, bean.getMora());
      pstm.setString(7, bean.getHoIng());
      pstm.setString(8, bean.getHoSalida());
      pstm.setInt(9, bean.getPeriodo());
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
