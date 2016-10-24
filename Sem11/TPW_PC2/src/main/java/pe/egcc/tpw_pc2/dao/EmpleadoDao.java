package pe.egcc.tpw_pc2.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.egcc.tpw_pc2.mapper.EmpleadoMapper;
import pe.egcc.tpw_pc2.model.Empleado;

@Repository
public class EmpleadoDao extends AbstractDao{

  public List<Empleado> consultar(int departamento){
    String sql = "select idempleado,apellido,nombre,"
        + "fecingreso,email,telefono,idcargo,"
        + "iddepartamento,sueldo,comision,jefe "
        + "from empleado where iddepartamento = ?";
    Object[] args = {departamento};
    EmpleadoMapper mapper = new EmpleadoMapper();
    List<Empleado> lista = jdbcTemplate.query(sql, args, mapper);
    return lista;
  }
  
}
