package models.productos.Departamento.Ropa;

import java.util.HashSet;
import java.util.Set;

import models.productos.Producto;

public class Ropa extends Producto {
    protected static Set<String> sDepartamentoList = new HashSet<>();
    protected static String seccion;

    public Ropa(String nombre, String precio) {
        super(nombre, precio);
        init();
        this.departamento = "Ropa y Zapatos";
    }

    public Ropa() {
        super();
        init();
        this.departamento = "Ropa y Zapatos";
    }

    public static void init() {
        sDepartamentoList.add("Playeras");
        sDepartamentoList.add("Zapatos");
        seccion = "Ropa y Zapatos";
    }

    public static Set<String> getSDepartamentosList() {
        return sDepartamentoList;
    }

    public static String getSeccion() {
        return seccion;
    }

}
