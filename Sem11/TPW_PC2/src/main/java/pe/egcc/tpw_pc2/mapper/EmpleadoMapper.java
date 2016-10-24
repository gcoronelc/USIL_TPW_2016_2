package pe.egcc.tpw_pc2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.egcc.tpw_pc2.model.Empleado;

public class EmpleadoMapper implements RowMapper<Empleado>{

  @Override
  public Empleado mapRow(ResultSet rs, int row) throws SQLException {
    Empleado bean = new Empleado();
    bean.setId(rs.getString("idempleado"));
    bean.setApellido(rs.getString("apellido"));
    bean.setNombre(rs.getString("nombre"));
    bean.setFecha(rs.getDate("fecingreso"));
    bean.setEmail(rs.getString("email"));
    bean.setTelefono(rs.getString("telefono"));
    bean.setCargo(rs.getString("idcargo"));
    bean.setDepartamento(rs.getInt("iddepartamento"));
    bean.setSueldo(rs.getDouble("sueldo"));
    bean.setComision(rs.getDouble("comision"));
    bean.setJefe(rs.getString("jefe")); 
    return bean;
  }

}
