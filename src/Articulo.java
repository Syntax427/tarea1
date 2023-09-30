public class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float peso, String nombre, String descripcion, float precio) {
        this.peso = peso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    public float getPeso() {
        return this.peso;
    }
    public String getNombre() {
        return this.nombre;
    }
    public float getPrecio() {
        return this.precio;
    }
}

