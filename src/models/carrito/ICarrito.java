package models.carrito;

import java.util.List;

import components.Carrito.CarritoItem;

public interface ICarrito {

    void agregarItem(CarritoItem item);

    boolean deleteItem(CarritoItem item);

    double calcularTotal();

    boolean checkOut();

    List<CarritoItem> loadItems();

    void clearAll();
}
