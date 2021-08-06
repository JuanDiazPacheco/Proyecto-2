package models.perfiles;

import java.time.LocalDate;
import java.util.LinkedList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.perfiles.cuentas.CuentaSaldo;

public class Cliente extends Persona {
    private String numeroCuenta;
    private CuentaSaldo cuentaAhorro;

    // Metodos Constructores

    public Cliente(String nombre, String apellidos, Direccion direccion, LocalDate nacimiento, float monto,
            String cuenta) {
        super(nombre, apellidos, direccion, nacimiento);

        this.numeroCuenta = cuenta;
        cuentaAhorro = new CuentaSaldo(monto);
    }

    public Cliente(String nombreCompleto, String direccion, String nacimiento, String monto, String cuenta) {

        super(nombreCompleto, direccion, nacimiento);

        this.numeroCuenta = cuenta;
        this.cuentaAhorro = new CuentaSaldo(Float.parseFloat(monto));
    }

    /**
     * @return String
     */
    // GETTERS

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    /**
     * @return LinkedList<String>
     */
    public LinkedList<String> getOperaciones() {
        return cuentaAhorro.getOperaciones();
    }

    /**
     * @return CuentaSaldo
     */
    public CuentaSaldo getCuentaAhorro() {
        return cuentaAhorro;
    }

    /**
     * @return String
     */
    public String getSaldoAhorro() {
        return String.valueOf(cuentaAhorro.getDinero());
    }

    /**
     * @return StringProperty
     */
    // GETTERS para la listas

    public StringProperty getNombreCompletoProperty() {
        StringProperty property = new SimpleStringProperty();
        property.set(super.getNombreCompleto());
        return property;
    }

    /**
     * @return StringProperty
     */
    public StringProperty getDireccionProperty() {
        StringProperty property = new SimpleStringProperty(getDireccion());
        return property;
    }

    /**
     * @return StringProperty
     */
    public StringProperty getSaldoAhorroProperty() {
        StringProperty property = new SimpleStringProperty(getSaldoAhorro());
        return property;
    }

    /**
     * @param operaciones
     */
    // SETTERS

    public void setOperaciones(LinkedList<String> operaciones) {
        cuentaAhorro.setOperaciones(operaciones);
    }

    /**
     * @param cuentaAhorro
     */
    public void setCuentaAhorro(CuentaSaldo cuentaAhorro) {
        this.cuentaAhorro = cuentaAhorro;
    }

    /**
     * @return String
     */
    // Otros métodos

    public String toString() {

        // Cadena para creacion de archivos
        return String.join("\n", "Numero Cuenta:" + numeroCuenta, super.toString(),
                "Saldo Cuenta de Ahorros:" + cuentaAhorro.getDinero() + "\n");

    }

}
