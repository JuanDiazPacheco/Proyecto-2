package models.productos.Departamento.Ropa;

public class Zapatos extends Ropa {

    public Zapatos(String nombre, String precio) {
        super(nombre, precio);
        this.sDepartamento = "Zapatos";
    }

    public Zapatos() {
        super();
        this.sDepartamento = "Zapatos";
    }
}
