package pe.egcc.eurekabank.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.egcc.eurekabank.db.AccesoDB;
import pe.egcc.eurekabank.model.Cuenta;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */     
public class CuentaService {
  
  public Cuenta traerCuenta(String codigo){
    Cuenta bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select c.chr_cuencodigo, c.dec_cuensaldo, cl.vch_clienombre, cl.vch_cliepaterno, cl.vch_cliematerno, m.vch_monedescripcion, c.vch_cuenestado from cuenta c join cliente cl on c.chr_cliecodigo = cl.chr_cliecodigo join moneda m on  c .chr_monecodigo = m.chr_monecodigo where chr_cuencodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Cuenta();
        bean.setCuenta(rs.getString("chr_cuencodigo"));
        bean.setSaldo(rs.getDouble("dec_cuensaldo"));
        bean.setCliente(rs.getString("vch_clienombre") +(" ")+ rs.getString("vch_cliepaterno") + (" ") + rs.getString("vch_cliematerno"));
        bean.setMoneda(rs.getString("vch_monedescripcion"));
        bean.setEstado(rs.getString("vch_cuenestado"));
      }
      rs.close();
      pstm.close();
      if(bean == null){
        throw new RuntimeException("Cuenta no existe.");
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
