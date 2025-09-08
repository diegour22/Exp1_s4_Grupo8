package cl.duoc.inventario.test;

import cl.duoc.inventario.modelo.*;

public class IntegracionTest {
    public static void main(String[] args) {
        System.out.println("===== PRUEBA DE INTEGRACIÓN =====");
        Inventario inventario = new Inventario();

        // Crear productos
        Producto p1 = new Producto("P001", "Polera", "Polera básica", 14990, 10);
        Producto p2 = new Producto("P002", "Pantalón", "Jeans azul", 29990, 5);

        // Agregar al inventario
        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);

        // Verificar listado
        System.out.println("Listado tras agregar:");
        inventario.listarProductos().forEach(System.out::println);

        // Modificar producto
        p1.actualizarPrecio(15990);
        p2.aumentarStock(3);
        System.out.println("Productos tras actualización:");
        inventario.listarProductos().forEach(System.out::println);

        // Eliminar producto
        inventario.eliminarProducto("P001");
        System.out.println("Listado tras eliminar P001:");
        inventario.listarProductos().forEach(System.out::println);
    }
}
