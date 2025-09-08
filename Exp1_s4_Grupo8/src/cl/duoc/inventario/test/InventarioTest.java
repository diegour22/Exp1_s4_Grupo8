package cl.duoc.inventario.test;

import cl.duoc.inventario.modelo.*;

public class InventarioTest {
    public static void main(String[] args) {
        System.out.println("===== PRUEBAS UNITARIAS: Inventario =====");
        Inventario inventario = new Inventario();

        // 1. Agregar producto
        Producto p1 = new Producto("P001", "Polera", "Polera básica", 14990, 10);
        inventario.agregarProducto(p1);
        System.out.println("Producto agregado: " + inventario.buscarPorCodigo("P001"));

        // 2. Buscar producto por nombre
        System.out.println("Buscar 'Polera': " + inventario.buscarPorNombre("Polera"));

        // 3. Eliminar producto
        boolean eliminado = inventario.eliminarProducto("P001");
        System.out.println("Producto eliminado: " + eliminado);

        // 4. Intentar eliminar producto inexistente
        boolean eliminado2 = inventario.eliminarProducto("P999");
        System.out.println("Eliminar producto inexistente: " + eliminado2);

        // 5. Listar productos (vacío)
        System.out.println("Listado actual: " + inventario.listarProductos());
    }
}
