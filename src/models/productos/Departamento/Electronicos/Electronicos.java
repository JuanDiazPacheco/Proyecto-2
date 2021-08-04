package models.productos.Departamento.Electronicos;

import java.util.HashSet;

import java.util.Set;

import models.productos.Producto;

public class Electronicos extends Producto {
    protected static Set<String> sDepartamentoList = new HashSet<>();
    protected static String seccion;

    public Electronicos(String nombre, String precio) {
        super(nombre, precio);
        init();
        this.departamento = "Electronicos y Celulares";
    }

    public Electronicos() {
        init();
        this.departamento = "Electronicos y Celulares";
    }

    public static void init() {
        sDepartamentoList.add("Pantallas");
        sDepartamentoList.add("Celulares");
        seccion = "Electronicos y Celulares";
    }

    public static Set<String> getSDepartamentosList() {
        return sDepartamentoList;
    }

    public static String getSeccion() {
        return seccion;
    }
}
