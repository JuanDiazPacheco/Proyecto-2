package models.productos;

public abstract class Producto {
    private String nombre;
    private double precio;
    private String marca;
    private String imagen;
    protected String departamento;

    protected String sDepartamento;

    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = Double.valueOf(precio);
    }

    public Producto() {

    }

    // Setters y getters

    protected void setPrecio(double precio) {
        this.precio = precio;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setMarca(String marca) {
        this.marca = marca;
    }

    protected void setImagen(String imagen) {
        this.imagen = imagen;
    }

    // Publicos

    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getImagen() {
        return this.imagen;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public String getSDepartamento() {
        return this.sDepartamento;
    }

    public String toString() {
        String sDep;
        if (sDepartamento == null)
            sDep = "NA";
        else
            sDep = sDepartamento;

        return String.join(",", nombre, String.valueOf(precio), marca, imagen, sDep);
    }

}
