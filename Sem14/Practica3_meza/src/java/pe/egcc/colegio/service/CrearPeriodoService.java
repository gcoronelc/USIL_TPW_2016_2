package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Periodo;


public class CrearPeriodoService {

  public void crearArticulo(Periodo bean) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      String sql = "insert into periodo(PERIODO, NOMBRE, INGRESO, MATRICULA, "
              + " CUOTA_NEW, CUOTA_OLD, MORA, HINGRESO, HSALIDA) values(?,?,?,?,?,?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getPeriodo());
      pstm.setString(2, bean.getNombre());
      pstm.setDouble(3, bean.getIngreso());
      pstm.setDouble(4, bean.getMatricula());
      pstm.setDouble(5, bean.getCuota_new());
      pstm.setDouble(6, bean.getCuota_old());
      pstm.setDouble(7, bean.getMora());
      pstm.setString(8, bean.getHoIng());
      pstm.setString(9, bean.getHoSalida());
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

  
}
