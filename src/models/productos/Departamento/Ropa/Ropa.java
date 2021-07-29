package models.productos.Departamento.Ropa;

import models.productos.Producto;

public abstract class Ropa extends Producto {

    public Ropa(String nombre, String precio) {
        super(nombre, precio);
        this.departamento = "Ropa y Zapatos";
    }

    public Ropa() {
        this.departamento = "Ropa y Zapatos";
    }

}
