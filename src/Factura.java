import java.util.Date;

public class Factura extends DocTributario{
    public Factura(OrdenCompra compraAsociada, String numero, String rut, Date fecha, Direccion adress){
        super(compraAsociada, numero, rut, fecha, adress);
    }
}
