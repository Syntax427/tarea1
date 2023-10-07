public class DetalleOrden {
    private int cantidad;
    private Articulo pedido;
    public DetalleOrden(int cantidad, Articulo pedido) {
        this.cantidad = cantidad;
        this.pedido = pedido;
    }
    public float calcPrecioSinIVA() {
        return this.cantidad * this.pedido.getPrecio();
    }
    public float calcIVA() {
        return this.calcPrecioSinIVA() * 0.19F;
    }
    public float calcPrecio() {
        return this.calcPrecioSinIVA() + this.calcIVA();
    }
    public float calcPeso() {
        return this.cantidad * this.pedido.getPeso();
    }
    public int getCantidad() {
        return this.cantidad;
    }

    @Override
    public String toString() {
        return "DetalleOrden : Cantidad: " + cantidad +
                ", Articulo: " + pedido.getNombre() +
                ", Precio sin IVA: " + calcPrecioSinIVA() +
                ", Precio con IVA: " + calcPrecio() +
                ", Peso: " + calcPeso();
    }
}