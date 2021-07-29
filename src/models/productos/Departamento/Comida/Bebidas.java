package models.productos.Departamento.Comida;

public class Bebidas extends Comida {

    public Bebidas(String nombre, String precio) {
        super(nombre, precio);
        this.sDepartamento = "Bebidas";
    }

    public Bebidas() {
        super();
        this.sDepartamento = "Bebidas";
    }

}
