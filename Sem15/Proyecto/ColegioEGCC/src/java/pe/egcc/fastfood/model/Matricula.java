package pe.egcc.fastfood.model;

import java.util.Date;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Matricula {

  private int idmat;
  private int idemp;
  private int idest;
  private int idseccion;
  private Date fecha;
  private int estado;
  private int idtipo;
  private double importe;

  public Matricula() {
  }

  public int getIdmat() {
    return idmat;
  }

  public void setIdmat(int idmat) {
    this.idmat = idmat;
  }

  public int getIdemp() {
    return idemp;
  }

  public void setIdemp(int idemp) {
    this.idemp = idemp;
  }

  public int getIdest() {
    return idest;
  }

  public void setIdest(int idest) {
    this.idest = idest;
  }

  public int getIdseccion() {
    return idseccion;
  }

  public void setIdseccion(int idseccion) {
    this.idseccion = idseccion;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public int getIdtipo() {
    return idtipo;
  }

  public void setIdtipo(int idtipo) {
    this.idtipo = idtipo;
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  
  
  
  
}
