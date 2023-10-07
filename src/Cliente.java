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
    public void addCompra(OrdenCompra compra) {
        compras.add(compra);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion.getDireccion();
    }

    public ArrayList<OrdenCompra> getCompras() {
        return compras;
    }

    public void addCompras(OrdenCompra compras) {
       this.compras.add(compras);
    }

    @Override
    public String toString() {
        return "Cliente : " + nombre +
                ", rut: " + rut +
                ", direccion: " + direccion + ", Cantidad de compras: " + compras.size();
    }
}
