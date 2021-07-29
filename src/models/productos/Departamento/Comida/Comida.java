package models.productos.Departamento.Comida;

import models.productos.Producto;

public abstract class Comida extends Producto {

    public Comida(String nombre, String precio) {
        super(nombre, precio);
        this.departamento = "Comida y Bebidas";
    }

    public Comida() {
        super();
        this.sDepartamento = "Bebidas";
    }

}
