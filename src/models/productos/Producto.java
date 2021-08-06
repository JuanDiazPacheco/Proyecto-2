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

    public Producto(String nombre, String precio, String imagen) {
        this.nombre = nombre;
        this.precio = Double.valueOf(precio);
        this.imagen = imagen;
    }

    public Producto() {

    }

    /**
     * @param precio
     */
    // Setters y getters

    protected void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @param nombre
     */
    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param marca
     */
    protected void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @param imagen
     */
    protected void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return String
     */
    // Publicos

    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return double
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * @return String
     */
    public String getImagen() {
        return this.imagen;
    }

    /**
     * @return String
     */
    public String getMarca() {
        return this.marca;
    }

    /**
     * @return String
     */
    public String getDepartamento() {
        return this.departamento;
    }

    /**
     * @return String
     */
    public String getSDepartamento() {
        return this.sDepartamento;
    }

    /**
     * @return String
     */
    public String toString() {
        String sDep;
        if (sDepartamento == null)
            sDep = "NA";
        else
            sDep = sDepartamento;

        return String.join(",", nombre, String.valueOf(precio), marca, imagen, sDep);
    }

}
