package models.productos.Departamento.Electronicos;

import models.productos.Producto;

public class Electronicos extends Producto {

    public Electronicos(String nombre, String precio) {
        super(nombre, precio);
        this.departamento = "Electronicos y Celulares";
    }

    public Electronicos() {
        this.departamento = "Electronicos y Celulares";
    }

}
