import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String rut;
    private String direccion;
    private ArrayList<OrdenCompra> compras;
    public Cliente(String nombre, String rut, Direccion adress){
        this.compras = new ArrayList<>();
        this.nombre = nombre;
        this.rut = rut;
        direccion = adress.getDireccion();
    }
    public void addCompra(OrdenCompra compra){
        compras.add(compra);
    }
}
