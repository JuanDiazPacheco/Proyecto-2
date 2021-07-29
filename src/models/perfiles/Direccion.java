package models.perfiles;

public class Direccion {
    private String calle;
    private String estado;
    private String colonia;
    private int codigoPostal;
    private byte numero;

    // Metodos Constructores

    public Direccion(String estado, String colonia, String calle, int codigoPostal, byte numero) {
        this.estado = estado;
        this.colonia = colonia;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.numero = numero;
    }

    public Direccion(String direccionCompleta) {
        String datos[] = direccionCompleta.split(",");
        this.estado = datos[0];
        this.colonia = datos[1];
        this.codigoPostal = Integer.parseInt(datos[2]);
        this.calle = datos[3];
        this.numero = Byte.parseByte(datos[4]);
    }

    // Metodos Getters

    public String toString() {
        String direccionCompleta = String.join(",", estado, colonia, String.valueOf(codigoPostal), calle,
                String.valueOf(numero));
        return direccionCompleta;
    }

}
