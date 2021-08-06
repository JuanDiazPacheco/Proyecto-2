package models.perfiles;

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Direccion direccion;
    private LocalDate nacimiento;

    /**
     * @return String
     */
    public String getNombreCompleto() {
        return String.join(" ", nombre, apellidoPaterno, apellidoMaterno);
    }

    /**
     * @return String
     */
    public String getDireccion() {
        return direccion.toString();
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * @param nacimiento
     */
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
        // modificar que sea realista
    }

    // Metodos Constructores

    public Persona(String nombre, String apellidos, Direccion direccion, LocalDate nacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidos.split(" ")[0];
        if (apellidos.split(" ").length == 2)
            this.apellidoMaterno = apellidos.split(" ")[1];
        this.direccion = direccion;
        this.nacimiento = nacimiento;
    }

    public Persona(String nombreCompleto, String direccion, String nacimiento) {

        String nombreApellidos[] = nombreCompleto.split(" , ");
        String apellidos[] = nombreApellidos[1].split(" ");

        this.nombre = nombreApellidos[0];
        this.apellidoPaterno = apellidos[0];
        if (apellidos.length == 2)
            this.apellidoMaterno = apellidos[1];
        this.nacimiento = LocalDate.parse(nacimiento);
        this.direccion = new Direccion(direccion);
    }

    /**
     * @return String
     */
    // Metodos

    public String toString() {
        String nombreCompleto;
        if (apellidoMaterno != null)
            nombreCompleto = String.join(" ", nombre, ",", apellidoPaterno, apellidoMaterno);
        else
            nombreCompleto = String.join(" ", nombre, ",", apellidoPaterno);
        String direccionCompleta = direccion.toString();
        return String.join("\n", "Nombre:" + nombreCompleto, "Direccion:" + direccionCompleta,
                "Nacimiento:" + nacimiento);
    }
}
