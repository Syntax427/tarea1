import java.util.Date;

public class Pago {
    private float monto;
    private Date fecha;
    private OrdenCompra compraAsociada;
    private float deudaAPagar;

    public Pago(OrdenCompra compra, float monto, Date fecha) {
        this.compraAsociada = compra;
        this.deudaAPagar = compraAsociada.getDeuda();
        this.monto = monto;
        this.fecha = fecha;
    }

    public float getMonto() {
        return this.monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public float getDeuda() {
        return deudaAPagar;
    }

    @Override
    public String toString() {
        return "Pago : Monto: " + monto +
                ", Fecha: " + fecha;
    }
}
