package pe.egcc.eurekabank.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pe.egcc.eurekabank.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class MovimientoService {
  
  public List<Map<String,Object>> traerMovimientosPorCuenta(String codCuenta){
    List<Map<String,Object>> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select int_movinumero, dtt_movifecha, tm.vch_tipodescripcion, tm.vch_tipoaccion, dec_moviimporte from movimiento m join tipomovimiento tm on m.chr_tipocodigo = tm.chr_tipocodigo where chr_cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codCuenta);
      ResultSet rs = pstm.executeQuery();
      while(rs.next()){
        Map<String,Object> rec = new HashMap<>();
        rec.put("int_movinumero", rs.getString("int_movinumero"));
        rec.put("dtt_movifecha", rs.getString("dtt_movifecha"));
        rec.put("vch_tipodescripcion", rs.getString("vch_tipodescripcion"));
        rec.put("vch_tipoaccion", rs.getString("vch_tipoaccion"));
        rec.put("dec_moviimporte", rs.getDouble("dec_moviimporte"));

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
