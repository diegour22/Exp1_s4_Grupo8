package cl.duoc.inventario.test;

import cl.duoc.inventario.modelo.Producto;

public class ProductoTest {
    public static void main(String[] args) {
        System.out.println("===== PRUEBAS UNITARIAS: Producto =====");

        // 1. Creación
        Producto p = new Producto("P001", "Polera", "Polera básica", 14990, 10);
        System.out.println("Creación OK: " + p);

        // 2. Actualización de precio
        p.actualizarPrecio(15990);
        System.out.println("Precio actualizado: " + p.getPrecio());

        // 3. Modificación de stock
        p.aumentarStock(5);
        System.out.println("Stock tras aumento: " + p.getStock());

        p.disminuirStock(3);
        System.out.println("Stock tras disminución: " + p.getStock());

        // 4. Setters
        p.setDescripcion("Polera básica algodón");
        System.out.println("Nueva descripción: " + p.getDescripcion());
    }
}
