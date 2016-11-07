package pe.egcc.fastfood.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.egcc.fastfood.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class PedidoService {
  
  public List<Map<String,Object>> traerPedidosPorCliente(String codCliente){
    List<Map<String,Object>> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select IdPedido, Documento, Numero, codCliente, "
              + "Cliente, RUC, Empleado, Fecha, Importe, Descuento, "
              + "Subtotal, IGV, Total from vPedido "
              + "where CodCliente = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codCliente);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        Map<String,Object> rec = new HashMap<>();
        rec.put("IdPedido", rs.getInt("IdPedido"));
        rec.put("Documento", rs.getString("Documento"));
        rec.put("Numero", rs.getString("Numero"));
        rec.put("CodCliente", rs.getString("CodCliente"));
        rec.put("Cliente", rs.getString("Cliente"));
        rec.put("RUC", rs.getString("RUC"));
        rec.put("Empleado", rs.getString("Empleado"));
        rec.put("Fecha", rs.getDate("Fecha"));
        rec.put("Importe", rs.getDouble("Importe"));
        rec.put("Descuento", rs.getDouble("Descuento"));
        rec.put("Subtotal", rs.getDouble("Subtotal"));
        rec.put("IGV", rs.getDouble("IGV"));
        rec.put("Total", rs.getDouble("Total"));
        lista.add(rec);
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
  } // Fin de traerPedidosPorCliente
  
} // Fin clase
