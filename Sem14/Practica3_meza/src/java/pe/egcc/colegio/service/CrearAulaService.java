package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Aula;


public class CrearAulaService {

  public void crearArticulo(Aula bean) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      String sql = "insert into aula(NOMBRE, PISO, NUMERO, CAPACIDAD) values(?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getNombre());
      pstm.setInt(2, bean.getPiso());
      pstm.setInt(3, bean.getNumero());
      pstm.setInt(4, bean.getCapacidad());
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
