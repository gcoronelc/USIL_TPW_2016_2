package pe.egcc.fastfood.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Categoria {

  private int idCat;
  private String nombre;
  private String prefijo;
  private int cont;

  public Categoria() {
  }

  public int getIdCat() {
    return idCat;
  }

  public void setIdCat(int idCat) {
    this.idCat = idCat;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getPrefijo() {
    return prefijo;
  }

  public void setPrefijo(String prefijo) {
    this.prefijo = prefijo;
  }

  public int getCont() {
    return cont;
  }

  public void setCont(int cont) {
    this.cont = cont;
  }

}
