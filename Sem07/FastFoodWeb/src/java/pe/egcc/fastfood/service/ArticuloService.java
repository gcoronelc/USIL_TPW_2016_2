package pe.egcc.fastfood.service;

import java.sql.Connection;
import pe.egcc.fastfood.db.AccesoDB;
import pe.egcc.fastfood.model.Articulo;

public class ArticuloService {

  public void crearArticulo(Articulo bean){
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      
      // Paso 2: Actualizar contador
      
      // Paso 3: Generar codigo
      
      // Paso 4: Insertar articulo
      
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "Error en la transacción.";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
  
}
