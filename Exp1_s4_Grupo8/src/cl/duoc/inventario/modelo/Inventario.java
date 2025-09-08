package cl.duoc.inventario.modelo;

import java.util.*;

/**
 * Gestiona un conjunto de productos.
 */
public class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) throw new IllegalArgumentException("Producto no puede ser nulo");
        productos.put(producto.getCodigo(), producto);
    }

    public boolean eliminarProducto(String codigo) {
        return productos.remove(codigo) != null;
    }

    public Producto buscarPorCodigo(String codigo) {
        return productos.get(codigo);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos.values()) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }

    public void generarInforme() {
        System.out.println("===== Informe de Inventario =====");
        for (Producto p : productos.values()) {
            System.out.println(p);
        }
    }
}
