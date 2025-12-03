/*
 * Nombre: Kenin Cusme
 * Fecha: 11/11/2025
 * Descripción: Clase modelo que representa un producto dentro del sistema.
 * Contiene los atributos básicos de un producto como id, nombre, tipo y precio.
 * Implementa encapsulamiento mediante el uso de atributos privados y métodos
 * getters y setters para el acceso controlado a cada campo.
 */

package models;

import java.time.LocalDate;

public class Producto {

    // Variables de la base de datos
    private Long id;
    private String nombre;
    private Categoria categoria;
    private String descripcion;
    private int stock;
    private double precio;
    private LocalDate fechaElaboracion;
    private LocalDate fechaCaducidad;

    // Variable local
    private int condicion;

    public Producto(long l, String laptop, String electrónico, double v) {
    }

    // Modificamos el constructor con las variables añadidas
    public Producto(Long id, int condicion, LocalDate fechaCaducidad, LocalDate fechaElaboracion,
                    String descripcion, int stock, double precio, String nombre, Categoria categoria) {
        this.id = id;
        this.condicion = condicion;
        this.fechaCaducidad = fechaCaducidad;
        this.fechaElaboracion = fechaElaboracion;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    // Implementamos los metodos setter y getter
    // de las variables añadidas

    public Long getIdProducto() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaElaboracion() {
        return fechaElaboracion;
    }

    public void setFechaElaboracion(LocalDate fechaElaboracion) {
        this.fechaElaboracion = fechaElaboracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdProducto(long id) {
    }
}