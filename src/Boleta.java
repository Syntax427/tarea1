import java.util.Date;

public class Boleta extends DocTributario {
    public Boleta(OrdenCompra compraAsociada, String numero, String rut, Date fecha, Direccion adress) {
        super(compraAsociada, numero, rut, fecha, adress);
    }
}
