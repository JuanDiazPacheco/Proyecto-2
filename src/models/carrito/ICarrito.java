package models.carrito;

import models.productos.Producto;

public interface ICarrito {

    void agregarItem(Producto producto);

    boolean deleteItem(Producto producto);

    double calcularTotal();

    boolean checkOut();
}
