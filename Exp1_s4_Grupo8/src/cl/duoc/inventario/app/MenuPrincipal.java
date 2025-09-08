package cl.duoc.inventario.app;

import cl.duoc.inventario.modelo.*;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private Inventario inventario;
    private Scanner scanner;

    public MenuPrincipal() {
        this.inventario = new Inventario();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        String opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1" -> agregarProducto();
                case "2" -> eliminarProducto();
                case "3" -> buscarProducto();
                case "4" -> listarProductos();
                case "5" -> inventario.generarInforme();
                case "0" -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("0"));
    }

    private void mostrarMenu() {
        System.out.println("\n===== MENÚ INVENTARIO =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Buscar producto");
        System.out.println("4. Listar productos");
        System.out.println("5. Generar informe");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarProducto() {
        try {
            System.out.print("Código: ");
            String codigo = scanner.nextLine().trim();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine().trim();
            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Stock: ");
            int stock = Integer.parseInt(scanner.nextLine().trim());

            Producto producto = new Producto(codigo, nombre, descripcion, precio, stock);
            inventario.agregarProducto(producto);
            System.out.println("✅ Producto agregado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al agregar producto: " + e.getMessage());
        }
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el código del producto a eliminar: ");
        String codigo = scanner.nextLine().trim();
        if (inventario.eliminarProducto(codigo)) {
            System.out.println("✅ Producto eliminado.");
        } else {
            System.out.println("⚠️ No se encontró el producto con ese código.");
        }
    }

    private void buscarProducto() {
        System.out.print("Ingrese nombre a buscar: ");
        String nombre = scanner.nextLine().trim();
        List<Producto> encontrados = inventario.buscarPorNombre(nombre);
        if (encontrados.isEmpty()) {
            System.out.println("⚠️ No se encontraron productos con ese nombre.");
        } else {
            System.out.println("Resultados de búsqueda:");
            encontrados.forEach(System.out::println);
        }
    }

    private void listarProductos() {
        List<Producto> productos = inventario.listarProductos();
        if (productos.isEmpty()) {
            System.out.println("⚠️ No hay productos en el inventario.");
        } else {
            productos.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        new MenuPrincipal().iniciar();
    }
}
