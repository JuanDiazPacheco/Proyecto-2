package models.productos.Departamento.Comida;

import java.util.HashSet;
import java.util.Set;

import models.productos.Producto;

public class Comida extends Producto {

    protected static Set<String> sDepartamentoList = new HashSet<>();
    protected static String seccion;

    public Comida(String nombre, String precio) {
        super(nombre, precio);
        this.departamento = "Comida y Bebidas";
        init();
    }

    public Comida() {
        super();
        this.departamento = "Comida y Bebidas";
        init();
    }

    public static void init() {
        seccion = "Comida y Bebidas";
        sDepartamentoList.add("Bebidas");
        sDepartamentoList.add("Frutas");
    }

    /**
     * @return Set<String>
     */
    public static Set<String> getSDepartamentosList() {
        return sDepartamentoList;
    }

    /**
     * @return String
     */
    public static String getSeccion() {
        return seccion;
    }

}
