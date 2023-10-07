import java.util.Date;

public class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(OrdenCompra compra, float monto, Date fecha, String banco, String numCuenta) {
        super(compra, monto, fecha);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    public String getBanco() {
        return this.banco;
    }

    public String getNumCuenta() {
        return this.numCuenta;
    }
}
