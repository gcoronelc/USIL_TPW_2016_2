package pe.egcc.tpw_pc2.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.egcc.tpw_pc2.model.Combo;

@Repository
public class ComboDao extends AbstractDao{

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public List<Combo> getDepartamentos(){
    String sql = "select iddepartamento codigo, nombre "
        + "from departamento";
    List<Combo> lista = jdbcTemplate.query(sql, 
        new BeanPropertyRowMapper(Combo.class));
    return lista;
  }
  
}
