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
}


