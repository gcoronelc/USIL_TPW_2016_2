package pe.egcc.tpw_pc2.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.egcc.tpw_pc2.mapper.EmpleadoMapper;
import pe.egcc.tpw_pc2.model.Empleado;
import pe.egcc.tpw_pc2.model.Usuario;

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
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public Usuario traerUsuario(String id){
    Usuario bean; 
    try{
      String sql = "select idempleado id, usuario, clave, estado "
        + "from usuario where idempleado = ? ";
      Object[] args = {id};
      bean = jdbcTemplate.queryForObject(sql, args, 
          new BeanPropertyRowMapper(Usuario.class) );
      bean.setClave("*****");
    } catch(EmptyResultDataAccessException e){
      bean = null;
    }
    return bean;
  }

  
  public void crearUsuario(Usuario bean) {
    String sql = "insert into usuario(idempleado,usuario,clave,estado) values(?,?,SHA(?),?)";
    Object[] args = {bean.getId(), bean.getUsuario(), bean.getClave(), bean.getEstado()};
    jdbcTemplate.update(sql, args);
  }
  
}
