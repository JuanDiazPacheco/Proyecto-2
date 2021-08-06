package models.productos.Departamento;

import models.productos.Producto;

public class Deportes extends Producto {

    public Deportes(String nombre, String precio) {
        super(nombre, precio);
        this.departamento = "Deportes";
    }

    public Deportes() {
        super();
        this.departamento = "Deportes";
    }

    public static void init() {
        seccion = "Deportes";
    }

    protected static String seccion;

    /**
     * @return String
     */
    public static String getSeccion() {
        return seccion;
    }

}
