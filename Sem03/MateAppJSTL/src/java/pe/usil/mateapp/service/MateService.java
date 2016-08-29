package pe.usil.mateapp.service;

import pe.usil.mateapp.model.MateModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class MateService {

  public int sumar(int n1, int n2) {
    return (n1 + n2);
  }
  
  public int restar(int num1, int num2) {
    return (num1 - num2);
  }  

  public void procesar(MateModel model) {
    int rpta = 0;
    switch (model.getOpera()) {
      case "S": // Sumar
        rpta = sumar(model.getNum1(), model.getNum2());
        break;
      case "R": // Sumar
        rpta = restar(model.getNum1(), model.getNum2());
        break;
    }
    model.setRpta(rpta);
  }



}
