package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Autor: Kenin Cusme
 * Fecha: 11/11/2025
 * Descripción:
 * Esta clase representa el detalle del carrito de compras.
 * Contiene una lista de los productos agregados y métodos
 * para añadir productos, obtener los ítems y calcular el total.
 */
public class DetalleCarro {

    // Lista que almacena los productos (ítems) agregados al carrito
    private List<ItemCarro> items;

    // Constructor que inicializa la lista vacía de ítems
    public DetalleCarro() {
        this.items = new ArrayList<>();
    }

    /*
     * Método que agrega un ítem al carrito.
     * Si el ítem ya existe, incrementa su cantidad.
     * Si no existe, lo añade como un nuevo elemento.
     */
    public void addItemCarro(ItemCarro itemCarro) {
        if (items.contains(itemCarro)) {
            // Busca el ítem existente en la lista
            Optional<ItemCarro> optionalItemCarro = items.stream()
                    .filter(i -> i.equals(itemCarro))
                    .findAny();

            // Si el ítem se encuentra, se incrementa su cantidad en 1
            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad() + 1);
            }
        } else {
            // Si el ítem no está en la lista, se agrega como nuevo
            this.items.add(itemCarro);
        }
    }

    // Retorna la lista completa de ítems del carrito
    public List<ItemCarro> getItem() {
        return items;
    }

    /*
     * Calcula el subtotal (sin impuestos)
     */
    public double getSubtotal() {
        double subtotal = 0.0;
        for (ItemCarro item : items) {
            subtotal += item.getProducto().getPrecio() * item.getCantidad();
        }
        // Redondeamos a 2 decimales
        return Math.round(subtotal * 100.0) / 100.0;
    }

    /*
     * Calcula el total aplicando el 15% de IVA al subtotal
     */
    public double getTotal() {
        double subtotal = getSubtotal();
        double total = subtotal * 1.15; // Aplica el 15%
        // Redondeamos a 2 decimales
        return Math.round(total * 100.0) / 100.0;
    }
}
