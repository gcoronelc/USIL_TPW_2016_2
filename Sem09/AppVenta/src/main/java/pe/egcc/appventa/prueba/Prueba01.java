package pe.egcc.appventa.prueba;

import pe.egcc.appventa.model.Venta;
import pe.egcc.appventa.service.VentaService;

public class Prueba01 {

  public static void main(String[] args) {
    // Datos
    Venta bean = new Venta(1000.0, 6);
    // Proceso
    VentaService service = new VentaService();
    service.procesar(bean);
    // Reporte
    System.out.println("Importe: " + bean.getImporte());
    System.out.println("Impuesto: " + bean.getImpuesto());
    System.out.println("Total: " + bean.getTotal());
  }
}
