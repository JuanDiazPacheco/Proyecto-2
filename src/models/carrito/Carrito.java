package models.carrito;

import models.productos.Producto;

public class Carrito implements ICarrito {

    @Override
    public void agregarItem(Producto producto) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean deleteItem(Producto producto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public double calcularTotal() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean checkOut() {
        // TODO Auto-generated method stub
        return false;
    }

}
