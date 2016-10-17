package pe.egcc.demojdbc.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import pe.egcc.demojdbc.dao.espec.CuentaDaoEspec;

@Repository
public class CuentaDaoImpl 
  extends AbstractDao implements CuentaDaoEspec{

  @Override
  public double getSaldo(String cuenta) {
    double saldo = 0.0;
    try {
      String sql = "select dec_cuensaldo from cuenta where chr_cuencodigo=?";
      Object[] args = {cuenta};
      saldo = jdbcTemplate.queryForObject(sql, args, Double.class);
    } catch (EmptyResultDataAccessException e) {
      throw new RuntimeException("Cuenta no existe.");
    }
    return saldo;
  }

}
