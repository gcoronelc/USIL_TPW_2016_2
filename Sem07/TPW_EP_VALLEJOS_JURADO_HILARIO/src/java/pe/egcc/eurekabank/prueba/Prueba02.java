package pe.egcc.eurekabank.prueba;

import java.util.Map;
import pe.egcc.eurekabank.service.MovimientoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class Prueba02 {
  
  public static void main(String[] args) {
    try {
      MovimientoService service = new MovimientoService();
      for(Map<String,Object> r: service.traerMovimientosPorCuenta("00100001")){
        System.out.println(r.get("dtt_movifecha") + " | " + r.get("dec_moviimporte"));
      }
    } catch (Exception e) {
    }
  }  
}
