package pe.egcc.appventa.service;

import org.springframework.stereotype.Service;

import pe.egcc.appventa.model.Venta;

@Service
public class VentaService {

  public void procesar(Venta venta){
    // Variables
    double importe, impuesto, total;
    // Proceso
    total = venta.getPrecio() * venta.getCant();
    importe = total / 1.18;
    impuesto = total - importe;
    // Reporte
    venta.setImporte(importe);
    venta.setImpuesto(impuesto);
    venta.setTotal(total);
  }
  
}
