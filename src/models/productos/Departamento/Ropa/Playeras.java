package models.productos.Departamento.Ropa;

public class Playeras extends Ropa {

    public Playeras(String nombre, String precio) {
        super(nombre, precio);
        this.sDepartamento = "Playeras";
    }

    public Playeras() {
        super();
        this.sDepartamento = "Playeras";
    }

}
