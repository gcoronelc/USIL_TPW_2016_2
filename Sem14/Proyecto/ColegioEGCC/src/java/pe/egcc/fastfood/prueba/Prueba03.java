package pe.egcc.fastfood.prueba;

import pe.egcc.fastfood.model.Articulo;
import pe.egcc.fastfood.service.ArticuloService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba03 {
    
    public static void main(String[] args) {
        try {
            Articulo bean = new Articulo(4, "Torta Helada", 5.50, 100);
            ArticuloService service = new ArticuloService();
            service.crearArticulo(bean);
            System.out.println("Codigo generado: " + bean.getId());
        } catch (Exception e) {
          System.err.println("Error: " + e.getMessage());
        }
    }
}
