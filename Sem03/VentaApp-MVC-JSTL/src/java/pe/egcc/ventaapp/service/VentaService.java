package pe.egcc.ventaapp.service;

import pe.egcc.ventaapp.model.VentaModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class VentaService {
  
  /**
   * Debes asumir que el model viene con
   * el precio y la cant.
   * 
   * @param model 
   */
  public void procesar( VentaModel model){
    // Variables
    double importe, impuesto, total;
    // Proceso
    total = redondear(model.getPrecio() * model.getCant());
    importe = redondear(total / 1.18);
    impuesto = redondear(total - importe);
    // reporte
    model.setImporte(importe);
    model.setImpuesto(impuesto);
    model.setTotal(total);
  }

  private double redondear(double valor) {
    valor = valor * 100;
    valor = Math.round(valor) * 1.0 / 100.0;
    return valor;
  }
}
