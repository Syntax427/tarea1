import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrdenCompra {
    private Cliente comprador;
    private Date fecha;
    private String estado;
    private ArrayList<DetalleOrden> detalles;
    private ArrayList<Pago> pagos;
    private float deuda;
    private DocTributario documentoAsociado;
    public OrdenCompra(Cliente comprador, ArrayList<Articulo> pedido, Date fecha, String estado) {
        this.comprador = comprador;
        this.fecha = fecha;
        this.estado = estado;
        detalles = new ArrayList<>();
        pagos = new ArrayList<>();
        documentoAsociado = null;

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
        deuda = calcPrecio();
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
    public void pagar(Pago pago){
        pagos.add(pago);
        float totalpagado = 0;
        for (Pago paga : pagos){
            totalpagado += paga.getMonto();
        }
        setDeuda(calcPrecio() - totalpagado);

        if (totalpagado < this.calcPrecio()){
            estado = "Por pagar";
        }
        else if (totalpagado >= this.calcPrecio()){
            estado = "Pagado";
            deuda = 0;
        }
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleOrden> detalles) {
        this.detalles = detalles;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public DocTributario getDocumentoAsociado() {
        return documentoAsociado;
    }

    public void setDocumentoAsociado(DocTributario documentoAsociado) {
        this.documentoAsociado = documentoAsociado;
    }

    @Override
    public String toString() {
        return "Comprador: " + comprador.getNombre() +
                ", Fecha: " + fecha +
                ", Estado: " + estado +
                ", Deuda: " + deuda +
                ", Documento Asociado: " + documentoAsociado.getNumero() +
                ", Peso Total: " + calcPeso() +
                ", Precio Total: " + calcPrecio();
    }

}
