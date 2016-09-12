package pe.egcc.ventaapp.prueba;

import pe.egcc.ventaapp.model.VentaModel;
import pe.egcc.ventaapp.service.VentaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Dato
    VentaModel model = new VentaModel(585.99, 5);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(model);
    // Reporte
    System.out.println("Importe: " + model.getImporte());
    System.out.println("Impuesto: " + model.getImpuesto());
    System.out.println("Total: " + model.getTotal());
  }
}
