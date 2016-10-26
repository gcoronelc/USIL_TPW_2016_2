package pe.egcc.tpw_pc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.tpw_pc2.dao.EmpleadoDao;
import pe.egcc.tpw_pc2.model.Empleado;
import pe.egcc.tpw_pc2.model.Usuario;

@Service
public class EmpleadoService {

  @Autowired
  private EmpleadoDao dao;
  
  
  public List<Empleado> consEmpleados(int dpto){
    return dao.consultar(dpto);
  }
  
  public Usuario traerUsuario(String id){
    return dao.traerUsuario(id);
  }

  public void crearUsuario(Usuario bean) {
    dao.crearUsuario(bean);
  }

  public void actualizarUsuario(Usuario bean) {
    
  }
  
}
