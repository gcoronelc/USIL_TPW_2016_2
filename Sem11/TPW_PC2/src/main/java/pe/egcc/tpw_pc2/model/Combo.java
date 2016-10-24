package pe.egcc.tpw_pc2.model;

public class Combo {

  private String codigo;
  private String nombre;

  public Combo() {
  }

  public Combo(String codigo, String nombre) {
    super();
    this.codigo = codigo;
    this.nombre = nombre;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
