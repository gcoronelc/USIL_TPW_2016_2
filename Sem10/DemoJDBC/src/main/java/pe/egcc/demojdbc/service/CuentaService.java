package pe.egcc.demojdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.demojdbc.dao.espec.CuentaDaoEspec;

@Service
public class CuentaService {

  @Autowired
  private CuentaDaoEspec cuentaDao;
  
  public double obtenerSaldo(String cuenta){
    if(cuenta.isEmpty()){
      throw new RuntimeException("Falta especificar la cuenta");
    }
    return cuentaDao.getSaldo(cuenta);
  }
  
}
