package models.carrito;

import java.util.LinkedList;
import java.util.List;

import components.Carrito.CarritoItem;

public class Carrito implements ICarrito {

    private static Carrito carrito;
    private List<CarritoItem> items;

    private Carrito() {
        items = new LinkedList<>();
    }

    /**
     * @return Carrito
     */
    public static Carrito getInstance() {
        if (carrito == null)
            carrito = new Carrito();
        return carrito;
    }

    /**
     * @param item
     */
    @Override
    public void agregarItem(CarritoItem item) {
        items.add(item);
    }

    /**
     * @param item
     * @return boolean
     */
    @Override
    public boolean deleteItem(CarritoItem item) {
        return items.remove(item);
    }

    /**
     * @return double
     */
    @Override
    public double calcularTotal() {
        // TODO Auto-generated method stub
        if (items.size() < 1)
            return 0.0;
        else {
            double total = 0.0;
            for (CarritoItem carritoItem : items) {
                total += carritoItem.getProducto().getPrecio();
            }
            return total;
        }
    }

    /**
     * @return boolean
     */
    @Override
    public boolean checkOut() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @return List<CarritoItem>
     */
    @Override
    public List<CarritoItem> loadItems() {
        return this.items;
    }

    @Override
    public void clearAll() {
        items.clear();
    }

}
