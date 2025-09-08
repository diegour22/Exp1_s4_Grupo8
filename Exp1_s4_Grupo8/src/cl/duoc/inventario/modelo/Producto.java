package cl.duoc.inventario.modelo;

/**
 * Representa un producto en el inventario.
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(String codigo, String nombre, String descripcion, double precio, int stock) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("Código no puede estar vacío");
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre no puede estar vacío");
        if (precio < 0) throw new IllegalArgumentException("Precio no puede ser negativo");
        if (stock < 0) throw new IllegalArgumentException("Stock no puede ser negativo");

        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio < 0) throw new IllegalArgumentException("Precio inválido");
        this.precio = precio;
    }
    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock inválido");
        this.stock = stock;
    }

    // Métodos adicionales
    public void actualizarPrecio(double nuevoPrecio) {
        setPrecio(nuevoPrecio);
    }

    public void aumentarStock(int cantidad) {
        if (cantidad > 0) this.stock += cantidad;
    }

    public void disminuirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= this.stock) this.stock -= cantidad;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | " + descripcion + " | $" + precio + " | Stock: " + stock;
    }
}
