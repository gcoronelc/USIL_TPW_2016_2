package pe.egcc.colegio.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.colegio.model.Aula;
import pe.egcc.colegio.db.AccesoDB;
import pe.egcc.colegio.model.Seccion;
import pe.egcc.colegio.model.Nivel;
import pe.egcc.colegio.model.Grado;
import pe.egcc.colegio.model.Periodo;


public class CrearSeccionService {

  public void crearArticulo(Seccion bean) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Inicio de la Tx
      cn.setAutoCommit(false);
      // Paso 1: Leer el contador y codigo de categoría
      String sql = "insert into seccion(IDNIVEL, IDGRADO, IDAULA, PERIODO) values(?,?,?,?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, bean.getIdNiv());
      pstm.setInt(2, bean.getIdGra());
      pstm.setInt(3, bean.getIdAul());
      pstm.setInt(4, bean.getPeriodo());
      pstm.execute();
      pstm.close();
      // Confirmar Tx      
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "Error en la transacción. ";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
  
    public List<Nivel> getNiveles() {
        List<Nivel> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idnivel, nombre "
                    + "from nivel ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Nivel bean = new Nivel();
                bean.setId(rs.getInt("idnivel"));
                bean.setNombre(rs.getString("nombre"));
                lista.add(bean);
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
    }
    
    public List<Aula> getAulas() {
        List<Aula> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idaula, nombre "
                    + "from aula";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Aula bean = new Aula();
                bean.setId(rs.getInt("idaula"));
                bean.setNombre(rs.getString("nombre"));
                lista.add(bean);
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
    }
    
    public List<Periodo> getPeriodos() {
        List<Periodo> lista = new ArrayList<>();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select periodo, nombre "
                    + "from periodo";
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Periodo bean = new Periodo();
                bean.setPeriodo(rs.getInt("periodo"));
                bean.setNombre(rs.getString("nombre"));
                lista.add(bean);
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
    }

  
}
