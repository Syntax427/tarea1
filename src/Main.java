import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Direccion direccion1 = new Direccion("Calle 1, Fuengirola");
        Cliente Juan = new Cliente("Juan Alberto", "123456789", direccion1);
        Date fechaCompra = new Date();

        ArrayList<Articulo> carrito = new ArrayList<>();

        Articulo pan = new Articulo(0.5f, "Pan", "Pan Hallulla", 200f);
        Articulo jamon = new Articulo(0.3f, "Jamón", "Jamon de pavo", 1575f);
        Articulo leche = new Articulo(1.0f, "Leche", "Leche entera", 1200f);
        Articulo queso = new Articulo(0.2f, "Queso", "Queso gauda", 3000f);
        Articulo manzana = new Articulo(1.2f, "Manzana", "Manzana verde", 280f);

        // Se añaden las cosas al carrito
        carrito.add(pan);
        carrito.add(pan);
        carrito.add(pan);
        carrito.add(jamon);
        carrito.add(leche);
        carrito.add(queso);
        carrito.add(manzana);
        carrito.add(manzana);

        OrdenCompra ordenJuan= new OrdenCompra(Juan, carrito, fechaCompra, "En proceso");
        Boleta boletaJuan = new Boleta(ordenJuan, "12345", "123456789", fechaCompra, direccion1);
        ordenJuan.setDocumentoAsociado(boletaJuan);
        Juan.addCompra(ordenJuan);

        System.out.println("Detalles del Cliente:");
        System.out.println(Juan.toString());
        System.out.println();

        System.out.println("Detalles de la Orden de Compra:");
        System.out.println(ordenJuan.toString());
        System.out.println();

        System.out.println("Detalles de la Boleta:");
        System.out.println(boletaJuan.toString());
        System.out.println();

        float total = ordenJuan.getDeuda();
        float cuota =  total / 4;
        Date fechapago = new Date();

        for (int i = 1; i <= 4; i++) {
            Tarjeta tarjetaJuan = new Tarjeta(ordenJuan, cuota, fechapago, "Visa", "1234567890" + "_" + i);
            ordenJuan.pagar(tarjetaJuan);
            System.out.println("Detalles de la Orden de Compra después del pago " + " con tarjeta:");
            System.out.println(ordenJuan.toString());
            System.out.println();
            System.out.println("Deuda restante: " + ordenJuan.getDeuda());
            System.out.println();
        }

        //Otra Compra
        System.out.println("------------------------------------Segunda compra de Juan------------------------------------");
        System.out.println();

        ArrayList<Articulo> segundoCarrito = new ArrayList<>();

        segundoCarrito.add(pan);
        segundoCarrito.add(pan);
        segundoCarrito.add(pan);

        OrdenCompra segundaOrdenJuan= new OrdenCompra(Juan, segundoCarrito, fechaCompra, "En proceso");
        Boleta SegundaBoletaJuan = new Boleta(segundaOrdenJuan, "12346", "123456789", fechaCompra, direccion1);
        segundaOrdenJuan.setDocumentoAsociado(SegundaBoletaJuan);

        System.out.println("Detalles del Cliente:");
        System.out.println(Juan.toString());
        System.out.println();

        System.out.println("Detalles de la Orden de Compra:");
        System.out.println(segundaOrdenJuan.toString());
        System.out.println();

        System.out.println("Detalles de la Boleta:");
        System.out.println(SegundaBoletaJuan.toString());
        System.out.println();


        float SegundoSotal = segundaOrdenJuan.getDeuda();
        Efectivo Billetera = new Efectivo(segundaOrdenJuan, 750, fechapago);

        System.out.println("Detalles del metodo de pago:");
        System.out.println(Billetera.toString());
        System.out.println();

        segundaOrdenJuan.pagar(Billetera);

        //Exige su cambio
        float vuelto = Billetera.calcDevolcion();
        System.out.println("Vuelto: " + vuelto);
        System.out.println();

        System.out.println("Detalles de la Orden de Compra después del pago " + " con efectivo:");
        System.out.println(segundaOrdenJuan.toString());
        System.out.println();
    }
}