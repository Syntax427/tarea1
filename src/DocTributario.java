import java.util.Date;

public class  DocTributario {
    OrdenCompra compraAsociada;
    private String numero;
    private String rut;
    private Date fecha;
    private String direccion;
    public DocTributario(OrdenCompra compraAsociada, String numero, String rut, Date fecha, Direccion adress){
        this.compraAsociada = compraAsociada;
        this.numero = numero;
        this.rut = rut;
        this.fecha = fecha;
        direccion = adress.getDireccion();
    }
    public OrdenCompra getCompraAsociada() {
        return compraAsociada;
    }

    public void setCompraAsociada(OrdenCompra compraAsociada) {
        this.compraAsociada = compraAsociada;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "DocTributario : Numero: " + numero +
                ", Rut: " + rut +
                ", Fecha: " + fecha +
                ", Direccion: " + direccion;
    }
}


