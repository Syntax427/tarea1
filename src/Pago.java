import java.util.Date;

public class Pago {
    private float monto;
    private Date fecha;
    private OrdenCompra compraAsociada;
    private float deuda;

    public Pago(OrdenCompra compra, float monto, Date fecha) {
        this.compraAsociada = compra;
        this.deuda = compraAsociada.getDeuda();
        this.monto = monto;
        this.fecha = fecha;
    }

    public float getMonto() {
        return this.monto;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public float getDeuda() {
        return deuda;
    }
}
