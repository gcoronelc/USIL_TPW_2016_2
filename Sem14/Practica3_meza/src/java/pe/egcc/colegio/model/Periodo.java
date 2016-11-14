package pe.egcc.colegio.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Periodo {

  private int periodo;
  private String nombre;
  private double ingreso;
  private double matricula;
  private double cuota_new;
  private double cuota_old;
  private int mora;
  private String hoIng;
  private String hoSalida;


  public Periodo() {
  }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getMatricula() {
        return matricula;
    }

    public void setMatricula(double matricula) {
        this.matricula = matricula;
    }

    public double getCuota_new() {
        return cuota_new;
    }

    public void setCuota_new(double cuota_new) {
        this.cuota_new = cuota_new;
    }

    public double getCuota_old() {
        return cuota_old;
    }

    public void setCuota_old(double cuota_old) {
        this.cuota_old = cuota_old;
    }

    public int getMora() {
        return mora;
    }

    public void setMora(int mora) {
        this.mora = mora;
    }

    public String getHoIng() {
        return hoIng;
    }

    public void setHoIng(String hoIng) {
        this.hoIng = hoIng;
    }

    public String getHoSalida() {
        return hoSalida;
    }

    public void setHoSalida(String hoSalida) {
        this.hoSalida = hoSalida;
    }

   
  

}
