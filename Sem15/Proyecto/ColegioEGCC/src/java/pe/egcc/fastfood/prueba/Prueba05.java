package pe.egcc.fastfood.prueba;

import pe.egcc.fastfood.model.Matricula;
import pe.egcc.fastfood.service.VentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba05 {
  
  public static void main(String[] args) {
    try {
      // Dato
      Matricula bean = new Matricula();
      bean.setIdest(3);
      bean.setIdseccion(6);
      bean.setIdemp(5);
      bean.setIdtipo(1);
      bean.setImporte(1000.0);
      // Proceso
      VentaService ventaService = new VentaService();
      ventaService.regIngreso(bean);
      // Reporte
      System.out.println("IdMat = " + bean.getIdmat());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
  
}
