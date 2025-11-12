package models;

import java.util.Objects;

/*
 * Autor: Kenin Cusme
 * Fecha: 11/11/2025
 * Descripción:
 * Esta clase representa un ítem dentro del carrito de compras.
 * Contiene la cantidad del producto y el producto asociado.
 */
public class ItemCarro {

    // Cantidad de unidades del producto
    private int cantidad;

    // Producto asociado al ítem del carrito
    private Producto producto;

    // Constructor que inicializa la cantidad y el producto
    public ItemCarro(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    // Getter que devuelve la cantidad del producto
    public int getCantidad() {
        return cantidad;
    }

    // Setter que permite modificar la cantidad del producto
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getter que devuelve el producto asociado
    public Producto getProducto() {
        return producto;
    }

    // Setter que permite cambiar el producto asociado
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /*
     * Método equals para comparar si dos ítems del carrito son iguales.
     * Se consideran iguales si tienen el mismo ID de producto y la misma cantidad.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si son el mismo objeto, retorna true
        if (o == null || getClass() != o.getClass()) return false; // Si no son del mismo tipo, retorna false
        ItemCarro itemCarro = (ItemCarro) o;
        // Compara el ID del producto y la cantidad
        return Objects.equals(producto.getIdProducto(), itemCarro.producto.getIdProducto()) &&
                Objects.equals(cantidad, itemCarro.cantidad);
    }
}
