package pe.egcc.colegio.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Seccion {

  private int idSec;
  private int idNiv;
  private int idGra;
  private int idAul;
  private int periodo;


  public Seccion() {
  }

    public int getIdSec() {
        return idSec;
    }

    public void setIdSec(int idSec) {
        this.idSec = idSec;
    }

    public int getIdNiv() {
        return idNiv;
    }

    public void setIdNiv(int idNiv) {
        this.idNiv = idNiv;
    }

    public int getIdGra() {
        return idGra;
    }

    public void setIdGra(int idGra) {
        this.idGra = idGra;
    }

    public int getIdAul() {
        return idAul;
    }

    public void setIdAul(int idAul) {
        this.idAul = idAul;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    
}
