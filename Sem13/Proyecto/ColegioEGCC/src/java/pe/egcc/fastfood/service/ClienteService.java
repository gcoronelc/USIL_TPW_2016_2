package pe.egcc.fastfood.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.fastfood.db.AccesoDB;
import pe.egcc.fastfood.model.Cliente;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */     
public class ClienteService {
  
  public Cliente traerCliente(String id){
    Cliente bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select IdCliente, NomCliente, RUC,"
              + "DirCliente, TelCliente "
              + "from cliente where IdCliente = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, id);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Cliente();
        bean.setId(rs.getString("IdCliente"));
        bean.setNombre(rs.getString("NomCliente"));
        bean.setRuc(rs.getString("RUC"));
        bean.setDireccion(rs.getString("DirCliente"));
        bean.setTelefono(rs.getString("TelCliente"));
      }
      rs.close();
      pstm.close();
      if(bean == null){
        throw new RuntimeException("Codigo no existe.");
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  } // Fin de traerCliente
          
} // Fin de clase
