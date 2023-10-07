import java.util.Date;

public class Efectivo extends Pago {
    public Efectivo(OrdenCompra compra, float monto, Date fecha) {
        super(compra, monto, fecha);
    }

    public float calcDevolcion(){
        float dev = 0.0F;
        if (this.getMonto() > getDeuda()) {
            dev = this.getMonto() - getDeuda();
        }
        return dev;
    }
}