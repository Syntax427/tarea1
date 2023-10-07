import java.util.Date;

public class Tarjeta extends Pago {
    private String tipo;
    private String numTransacción;

    public Tarjeta(OrdenCompra compra, float monto, Date fecha, String tipo, String numTransacción) {
        super(compra, monto, fecha);
        this.tipo = tipo;
        this.numTransacción = numTransacción;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getNumTransacción() {
        return this.numTransacción;
    }
}
