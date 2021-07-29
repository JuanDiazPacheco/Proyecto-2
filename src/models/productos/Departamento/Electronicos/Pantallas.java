package models.productos.Departamento.Electronicos;

public class Pantallas extends Electronicos {

    public Pantallas(String nombre, String precio) {
        super(nombre, precio);
        this.sDepartamento = "Pantallas";
    }

    public Pantallas() {
        super();
        this.sDepartamento = "Pantallas";
    }

}
