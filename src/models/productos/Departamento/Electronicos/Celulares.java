package models.productos.Departamento.Electronicos;

public class Celulares extends Electronicos {

    public Celulares(String nombre, String precio) {
        super(nombre, precio);
        this.sDepartamento = "Celulares";
    }

    public Celulares() {
        super();
        this.sDepartamento = "Celulares";
    }

}
