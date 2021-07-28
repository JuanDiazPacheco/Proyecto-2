package models.perfiles;

import java.time.LocalDate;
import java.util.LinkedList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.perfiles.cuentas.CuentaAhorro;

public class Cliente extends Persona {
    private String numeroCuenta;

    private CuentaAhorro cuentaAhorro;

    // Metodos Constructores

    public Cliente(String nombre, String apellidos, Direccion direccion, LocalDate nacimiento, float monto,
            String cuenta) {
        super(nombre, apellidos, direccion, nacimiento);

        this.numeroCuenta = cuenta;
        cuentaAhorro = new CuentaAhorro(monto);
    }

    public Cliente(String nombreCompleto, String direccion, String nacimiento, String monto, String cuenta) {

        super(nombreCompleto, direccion, nacimiento);

        this.numeroCuenta = cuenta;
        this.cuentaAhorro = new CuentaAhorro(Float.parseFloat(monto));
    }

    // GETTERS

    public String toString() {

        // Cadena para creacion de archivos
        return String.join("\n", "Numero Cuenta:" + numeroCuenta, super.toString(),
                "Saldo Cuenta de Ahorros:" + cuentaAhorro.getDinero() + "\n");

    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    // Metodos getter de las cuentas se tiene DUDAS

    public String getSaldoAhorro() {
        return String.valueOf(cuentaAhorro.getDinero());
    }

    public LinkedList<String> getOperaciones() {
        return cuentaAhorro.getOperaciones();
    }

    public CuentaAhorro getCuentaAhorro() {
        return cuentaAhorro;
    }

    // SETTERS

    public void setOperaciones(LinkedList<String> operaciones) {
        cuentaAhorro.setOperaciones(operaciones);
    }

    // Metodo setter para cargar la cuenta de inversion desde un archivo

    public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
        this.cuentaAhorro = cuentaAhorro;
    }

    // Metodos

    // Metodo para depositar dinero, se tiene duda sobre este método

    public boolean retirarDinero(double monto) {
        return cuentaAhorro.retirarDinero(monto, false);
    }

    // Metodo para depositar dinero, se tiene duda sobre este método

    public void depositarDinero(double deposito) {
        cuentaAhorro.depositarDinero(deposito);
    }

    public StringProperty getNombreCompletoProperty() {
        StringProperty property = new SimpleStringProperty();
        property.set(super.getNombreCompleto());
        return property;
    }

    public StringProperty getDireccionProperty() {
        StringProperty property = new SimpleStringProperty(getDireccion());
        return property;
    }

    public StringProperty getSaldoAhorroProperty() {
        StringProperty property = new SimpleStringProperty(getSaldoAhorro());
        return property;
    }

}
