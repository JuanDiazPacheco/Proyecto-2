package models.productos.Departamento.Comida;

public class Frutas extends Comida {

    public Frutas(String nombre, String precio) {
        super(nombre, precio);
        this.sDepartamento = "Frutas";
    }

    public Frutas() {
        super();
        this.sDepartamento = "Frutas";
    }

}
