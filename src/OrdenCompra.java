import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrdenCompra {
    private Date fecha;
    private String estado;
    private ArrayList<DetalleOrden> detalles = new ArrayList();
    public OrdenCompra(ArrayList<Articulo> pedido, Date fecha, String estado) {
        this.fecha = fecha;
        this.estado = estado;
        while(!pedido.isEmpty()){

            Articulo articulo = pedido.get(0);
            int cantidad = 1;
            pedido.remove(0);

            Iterator<Articulo> iterator = pedido.iterator();

            while (iterator.hasNext()){
                Articulo next = iterator.next();
                if (articulo.equals(next)){
                    cantidad++;
                    iterator.remove();
                }
            }
            detalles.add(new DetalleOrden(cantidad, articulo));
        }
    }
    public float calcPrecioSinIVA() {
        float suma = 0.0F;
        for(DetalleOrden detalle : detalles) {
            suma += detalle.calcPrecioSinIVA();
        }
        return suma;
    }
    public float calcIVA() {
        return this.calcPrecioSinIVA() * 0.19F;
    }
    public float calcPrecio() {
        return this.calcPrecioSinIVA() + calcIVA();
    }
    public float calcPeso() {
        float suma = 0.0F;
        for(DetalleOrden detalle : detalles) {
            suma += detalle.calcPeso();
        }
        return suma;
    }

}
