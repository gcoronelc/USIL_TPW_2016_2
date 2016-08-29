package pe.usil.mateapp.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class MateModel {
  
  private String opera;
  private int num1;
  private int num2;
  private int rpta;

  public MateModel() {
  }

  public MateModel(String opera, int num1, int num2) {
    this.opera = opera;
    this.num1 = num1;
    this.num2 = num2;
    this.rpta = rpta;
  }

  public MateModel(String opera, int num1, int num2, int rpta) {
    this.opera = opera;
    this.num1 = num1;
    this.num2 = num2;
    this.rpta = rpta;
  }

  public String getOpera() {
    return opera;
  }

  public void setOpera(String opera) {
    this.opera = opera;
  }

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getRpta() {
    return rpta;
  }

  public void setRpta(int rpta) {
    this.rpta = rpta;
  }
  
  
  
}
