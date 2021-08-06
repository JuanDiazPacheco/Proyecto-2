package models.productos;

import models.productos.Departamento.Deportes;
import models.productos.Departamento.Comida.Bebidas;
import models.productos.Departamento.Comida.Comida;
import models.productos.Departamento.Comida.Frutas;
import models.productos.Departamento.Electronicos.Celulares;
import models.productos.Departamento.Electronicos.Electronicos;
import models.productos.Departamento.Electronicos.Pantallas;
import models.productos.Departamento.Ropa.Playeras;
import models.productos.Departamento.Ropa.Ropa;
import models.productos.Departamento.Ropa.Zapatos;

public class ProductoFactory {

    /**
     * @param departamento
     * @param atributos
     * @return Producto
     */
    public static Producto nuevoProducto(String departamento, String[] atributos) {
        Producto nuevo = null;

        switch (departamento) {
            case "Comida y Bebidas":
                nuevo = nuevaComida(atributos[atributos.length - 1]);
                break;
            case "Electronicos y Celulares":
                nuevo = nuevoElectronico(atributos[atributos.length - 1]);
                break;
            case "Ropa y Zapatos":
                nuevo = nuevaRopa(atributos[atributos.length - 1]);
                break;
            case "Deportes":
                nuevo = nuevoDeportes(atributos[atributos.length - 1]);
                break;
        }

        if (nuevo != null) {
            nuevo.setNombre(atributos[0]);
            nuevo.setPrecio(Double.valueOf(atributos[1]));
            nuevo.setMarca(atributos[2]);
            nuevo.setImagen(atributos[3]);
        }

        return nuevo;

    }

    /**
     * @param sDepartamento
     * @return Deportes
     */
    private static Deportes nuevoDeportes(String sDepartamento) {
        return new Deportes();
    }

    /**
     * @param sDepartamento
     * @return Ropa
     */
    private static Ropa nuevaRopa(String sDepartamento) {
        switch (sDepartamento) {
            case "Playeras":
                return new Playeras();
            case "Zapatos":
                return new Zapatos();
            default:
                return new Ropa();
        }

    }

    /**
     * @param sDepartamento
     * @return Electronicos
     */
    private static Electronicos nuevoElectronico(String sDepartamento) {
        switch (sDepartamento) {
            case "Celulares":
                return new Celulares();
            case "Pantallas":
                return new Pantallas();
            default:
                return new Electronicos();
        }

    }

    /**
     * @param sDepartamento
     * @return Comida
     */
    private static Comida nuevaComida(String sDepartamento) {
        switch (sDepartamento) {
            case "Frutas":
                return new Frutas();
            case "Bebidas":
                return new Bebidas();
            default:
                return new Comida();
        }

    }

}
